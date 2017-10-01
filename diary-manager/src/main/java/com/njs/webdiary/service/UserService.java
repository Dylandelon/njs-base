package com.njs.webdiary.service;

import com.njs.webdiary.async.MailTask;
import com.njs.webdiary.dao.InfoRepository;
import com.njs.webdiary.dao.UserRepository;
import com.njs.webdiary.entity.InfoEntity;
import com.njs.webdiary.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private InfoRepository infoRepository;

    public UserEntity getProfile(int sessionUid, int uid) {
        //如果是浏览别人的主页，则增加主页浏览数
        if(sessionUid!=uid){
            userRepository.updateScanCount(uid);
        }
        //从数据库得到User对象
        UserEntity user = userRepository.findOne(uid);
        //设置获赞数，关注数，粉丝数
        Jedis jedis = jedisPool.getResource();
        user.setFollowCount((int)(long)jedis.scard(uid+":follow"));
        user.setFollowerCount((int)(long)jedis.scard(uid+":fans"));
        String likeCount = jedis.hget("vote",uid+"");
        if(likeCount==null){
            user.setLikeCount(0);
        }else {
            user.setLikeCount(Integer.valueOf(likeCount));
        }

        if(jedis!=null){
            jedisPool.close();
        }
        return user;
    }

    public UserEntity getEditInfo(int uid) {
        return userRepository.findOne(uid);
    }

    public void updateUser(UserEntity user) {
        userRepository.save(user);
    }

    public void record(StringBuffer requestURL, String contextPath, String remoteAddr) {
        InfoEntity info = new InfoEntity();
        info.setRequestUrl(requestURL.toString());
        info.setContextPath(contextPath);
        info.setRemoteAddr(remoteAddr);
        infoRepository.save(info);
    }

    public List<UserEntity> listUserByTime() {
        return userRepository.findTop6ByOrderByJoinTimeDesc();
    }

    public List<UserEntity> listUserByHot() {
        return userRepository.findTop6ByOrderByPostCountDesc();
    }

    public void updateHeadUrl(int uid, String headUrl) {
        userRepository.updateHeadUrl(headUrl,uid);
    }

    public void unfollow(int sessionUid, int uid) {
        Jedis jedis = jedisPool.getResource();
        Transaction tx = jedis.multi();
        tx.srem(sessionUid+":follow", String.valueOf(uid));
        tx.srem(uid+":fans", String.valueOf(sessionUid));
        tx.exec();

        if(jedis!=null){
            jedisPool.close();
        }
    }

    public void follow(int sessionUid, int uid) {
        Jedis jedis = jedisPool.getResource();
        Transaction tx = jedis.multi();
        tx.sadd(sessionUid+":follow", String.valueOf(uid));
        tx.sadd(uid+":fans", String.valueOf(sessionUid));
        tx.exec();
        if(jedis!=null){
            jedisPool.close();
        }
    }

    public boolean getFollowStatus(int sessionUid, int uid) {
        Jedis jedis = jedisPool.getResource();
        boolean following = jedis.sismember(sessionUid+":follow", String.valueOf(uid));
        if(jedis!=null){
            jedisPool.close();
        }
        return following;
    }

    public String updatePassword(String password, String newpassword, String repassword, int sessionUid) {

        UserEntity userEntity = userRepository.getOne(sessionUid);
        String oldPassword = userEntity.getPassword();
        if(!oldPassword.equals(password)){
            return "原密码输入错误~";
        }

        if(newpassword.length()<6 ||newpassword.length()>20){
            return "新密码长度要在6~20之间~";
        }

        if(!newpassword.equals(repassword)){
            return "新密码两次输入不一致~";
        }

        userEntity.setPassword(newpassword);
        userRepository.save(userEntity);
        return "ok";
    }

    //发送忘记密码确认邮件
    public void forgetPassword(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        String verifyCode = userEntity.getActivateCode();
        System.out.println("verifyCode:"+verifyCode);
        //发送邮件
        taskExecutor.execute(new MailTask(verifyCode,email,javaMailSender,2));
    }

    public void verifyForgetPassword(String code) {
        System.out.println("更新前："+code);
        userRepository.updatePasswordByActivateCode(code);
        System.out.println("更新后："+code);
    }
}

