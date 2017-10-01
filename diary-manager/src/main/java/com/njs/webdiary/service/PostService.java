package com.njs.webdiary.service;

import com.njs.webdiary.async.MessageTask;
import com.njs.webdiary.dao.MessageRepository;
import com.njs.webdiary.dao.PostRepository;
import com.njs.webdiary.dao.ReplyRepository;
import com.njs.webdiary.dao.UserRepository;
import com.njs.webdiary.entity.PageBean;
import com.njs.webdiary.entity.PostEntity;
import com.njs.webdiary.util.MyConstant;
import com.njs.webdiary.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TaskExecutor taskExecutor;

    //根据uid，获得帖子列表
    public List<PostEntity> getPostList(int uid) {
        return postRepository.findByUid(uid);
    }

    public int publishPost(PostEntity post) {
        //构造帖子
        post.setPublishTime(MyUtil.formatDate(new Date()));
        post.setReplyTime(MyUtil.formatDate(new Date()));
        post.setReplyCount(0);
        post.setLikeCount(0);
        post.setScanCount(0);
        //插入一条帖子记录
        postRepository.save(post);
        System.out.println(post.getPid());
        //更新用户发帖量
        userRepository.updatePostCount(post.getUserByUid().getUid());

        return post.getPid();
    }

    //按时间列出帖子
    public Page<PostEntity> listPostByTime(int curPage) {
        //每页记录数，从哪开始
        int limit = 8;
        int offset = (curPage-1) * limit;
        //获得总记录数，总页数
//        int allCount = (int) postRepository.count();
//        int allPage = 0;
//        if (allCount <= limit) {
//            allPage = 1;
//        } else if (allCount / limit == 0) {
//            allPage = allCount / limit;
//        } else {
//            allPage = allCount / limit + 1;
//        }
        //分页得到数据列表
        PageRequest pageRequest = new PageRequest(offset, limit, new Sort(Sort.Direction.DESC,"replyTime"));
        Page<PostEntity> postPage =  postRepository.findAll(pageRequest);
        List<PostEntity> postList = postPage.getContent();
        Jedis jedis = jedisPool.getResource();
        for(PostEntity post : postList){
            post.setLikeCount((int)(long)jedis.scard(post.getPid()+":like"));
        }
        //构造PageBean
//        PageBean<PostEntity> pageBean = new PageBean<>(allPage,curPage);
//        pageBean.setList(postList);

        if(jedis!=null){
            jedisPool.close();
        }
        return postPage;
    }

    public PostEntity getPostByPid(int pid) {
        //更新浏览数
        postRepository.updateScanCount(pid);
        PostEntity post =postRepository.findOne(pid);
        //设置点赞数
        Jedis jedis = jedisPool.getResource();
        long likeCount = jedis.scard(pid+":like");
        post.setLikeCount((int)likeCount);

        if(jedis!=null){
            jedisPool.close();
        }
        return post;
    }

    //点赞
    public String clickLike(int pid, int sessionUid) {
        Jedis jedis = jedisPool.getResource();
        //pid被sessionUid点赞
        jedis.sadd(pid+":like", String.valueOf(sessionUid));
        //增加用户获赞数
        jedis.hincrBy("vote",sessionUid+"",1);

        //插入一条点赞消息
        taskExecutor.execute(new MessageTask(messageRepository,userRepository,postRepository,replyRepository,pid,0,sessionUid, MyConstant.OPERATION_CLICK_LIKE));
        String result = String.valueOf(jedis.scard(pid+":like"));

        if(jedis!=null){
            jedisPool.close();
        }
        return result;
    }

    //某用户是否赞过某帖子
    public boolean getLikeStatus(int pid, int sessionUid) {
        Jedis jedis = jedisPool.getResource();
        boolean result = jedis.sismember(pid+":like", String.valueOf(sessionUid));

        if(jedis!=null){
            jedisPool.close();
        }
        return result;
    }
}

