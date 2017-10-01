package com.njs.webdiary.async;

import com.njs.webdiary.dao.MessageRepository;
import com.njs.webdiary.dao.PostRepository;
import com.njs.webdiary.dao.ReplyRepository;
import com.njs.webdiary.dao.UserRepository;
import com.njs.webdiary.entity.MessageEntity;
import com.njs.webdiary.entity.PostEntity;
import com.njs.webdiary.entity.UserEntity;
import com.njs.webdiary.util.MyConstant;

public class MessageTask implements Runnable {

    private MessageRepository messageRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;
    private ReplyRepository replyRepository;
    private int pid;
    private int rid;
    private int sessionUid;
    private int operation;

    public MessageTask(MessageRepository messageRepository, UserRepository userRepository, PostRepository postRepository, ReplyRepository replyRepository, int pid, int rid, int sessionUid, int operation) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.replyRepository = replyRepository;
        this.pid = pid;
        this.rid = rid;
        this.sessionUid = sessionUid;
        this.operation = operation;
    }

    @Override
    public void run() {
        //创建消息对象
        MessageEntity message = new MessageEntity();
        //设置是谁的消息
        PostEntity postEntity = postRepository.findOne(pid);
        int uid = postEntity.getUid();
        message.setUid(uid);

        //设置点赞人id和用户名
        UserEntity user = userRepository.findOne(sessionUid);
        message.setOtherId(user.getUid());
        message.setOtherUsername(user.getUsername());
        message.setPostId(pid);

        //设置操作和展示的内容
        if(operation== MyConstant.OPERATION_CLICK_LIKE){
            message.setOperation("赞了您的帖子");
            message.setDisplayedContent(postEntity.getTitle());
        }else if(operation==MyConstant.OPERATION_REPLY){
            message.setOperation("回复了您的帖子");
            message.setDisplayedContent(postEntity.getTitle());
        }else if(operation==MyConstant.OPERATION_COMMENT){
            message.setOperation("评论了你帖子的回复");
            String content = replyRepository.findOne(rid).getContent();
            message.setDisplayedContent(content.substring(content.indexOf("<p>") + 3,content.indexOf("</p>")));
        }

        //向数据库插入一条消息
        messageRepository.save(message);
    }
}


