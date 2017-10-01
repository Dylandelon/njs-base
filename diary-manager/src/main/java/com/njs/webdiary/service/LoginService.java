package com.njs.webdiary.service;


import com.njs.webdiary.async.MailTask;
import com.njs.webdiary.dao.UserRepository;
import com.njs.webdiary.entity.UserEntity;
import com.njs.webdiary.util.MyConstant;
import com.njs.webdiary.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LoginService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TaskExecutor taskExecutor;

    //注册
    public String register(UserEntity user,String repassword) {

        //校验邮箱格式
        Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$");
        Matcher m = p.matcher(user.getEmail());
        if(!m.matches()){
            return "邮箱格式有问题啊~";
        }

        //校验密码长度
        p = Pattern.compile("^\\w{6,20}$");
        m = p.matcher(user.getPassword());
        if(!m.matches()){
            return "密码长度要在6到20之间~";
        }

        //检查密码
        if(!user.getPassword().equals(repassword)){
            return "两次密码输入不一致~";
        }

        //检查邮箱是否被注册
        int emailCount = userRepository.countByEmail(user.getEmail());
        if(emailCount>0){
            return "该邮箱已被注册~";
        }

        //构造user，设置未激活
        user.setActived(0);
        String activateCode = MyUtil.createActivateCode();
        user.setActivateCode(activateCode);
        user.setJoinTime(MyUtil.formatDate(new Date()));
        user.setUsername("DF"+new Random().nextInt(10000)+"号");
        user.setHeadUrl(MyConstant.QINIU_IMAGE_URL +"head.jpg");

        //发送邮件
        taskExecutor.execute(new MailTask(activateCode,user.getEmail(),javaMailSender,1));

        //向数据库插入记录
        userRepository.save(user);

        return "ok";
    }



    //登录
    public Map<String,Object> login(UserEntity user) {

        Map<String,Object> map = new HashMap<>();
        UserEntity user1 = new UserEntity();
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        Example<UserEntity> userExample = Example.of(user1);
        UserEntity user2 = userRepository.findOne(userExample);
//        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher()
        Integer uid = user2.getUid();
        if(uid==null){
            map.put("status","no");
            map.put("error","用户名或密码错误~");
            return map;
        }

        UserEntity user3 = userRepository.findByEmail(user.getEmail());
        if(user3 == null || user3.getActived()==0){
            map.put("status","no");
            map.put("error","您还没有激活账户哦，请前往邮箱激活~");
            return map;
        }
        UserEntity user4 = userRepository.getOne(uid);
        String headUrl = user4.getHeadUrl();

        map.put("status","yes");
        map.put("uid",uid);
        map.put("headUrl",headUrl);
        return map;
    }

    public void activate(String activateCode) {
        userRepository.updateActived(activateCode);
    }
}
