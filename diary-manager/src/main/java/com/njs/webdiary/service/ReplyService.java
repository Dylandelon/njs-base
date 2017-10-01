package com.njs.webdiary.service;

import com.njs.webdiary.async.MessageTask;
import com.njs.webdiary.dao.*;
import com.njs.webdiary.entity.CommentEntity;
import com.njs.webdiary.entity.PostEntity;
import com.njs.webdiary.entity.ReplyEntity;
import com.njs.webdiary.entity.UserEntity;
import com.njs.webdiary.util.MyConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private TaskExecutor taskExecutor;

    private CommentRepository commentRepository;

    //回复
    public void reply(int sessionUid, int pid, String content) {
        //构造Reply对象
        UserEntity user = new UserEntity(sessionUid);
        PostEntity post = new PostEntity(pid);
        ReplyEntity reply =new ReplyEntity();
        reply.setUserByUid(user);
        reply.setPostByPid(post);
        reply.setContent(content);
        reply.setReplyTime(LocalDateTime.now().toString());
        //向reply表插入一条记录
        replyRepository.save(reply);
        //更新帖子的回复数
        postRepository.updateReplyCount(pid);
        //更新最后回复时间
        postRepository.updateReplyTime(pid);
        //插入一条回复消息
        taskExecutor.execute(new MessageTask(messageRepository,userRepository,postRepository,replyRepository,pid,0,sessionUid, MyConstant.OPERATION_REPLY));

    }

    //评论
    public void comment(int pid,int sessionUid, int rid, String content) {
        //构造Comment
        UserEntity user = new UserEntity(sessionUid);
        ReplyEntity reply = new ReplyEntity(rid);
        CommentEntity comment = new CommentEntity();
        comment.setUserByUid(user);
        comment.setReplyByRid(reply);
        comment.setContent(content);
        //插入一条评论
        commentRepository.save(comment);
        //更新最后回复时间
        postRepository.updateReplyTime(pid);
        //插入一条评论消息
        taskExecutor.execute(new MessageTask(messageRepository,userRepository,postRepository,replyRepository,pid,rid,sessionUid, MyConstant.OPERATION_COMMENT));

    }

    //根据pid列出回复
    public List<ReplyEntity> listReply(int pid) {
        //列出回复
        List<ReplyEntity> replyList = replyRepository.listReply(pid);
        for(ReplyEntity reply : replyList){
            //列出每条回复下的评论
            List<CommentEntity> commentList = commentRepository.listComment(reply.getRid());
            reply.setCommentsByRid(commentList);
        }
        return replyList;
    }
}

