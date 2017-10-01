package com.njs.webdiary.controller;


import com.njs.webdiary.entity.*;
import com.njs.webdiary.service.PostService;
import com.njs.webdiary.service.ReplyService;
import com.njs.webdiary.service.TopicService;
import com.njs.webdiary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.www.http.PosterOutputStream;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class PostController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private ReplyService replyService;


    //去发帖的页面
    @RequestMapping("/toPublish.do")
    public String toPublish(Model model){
        List<TopicEntity> topicList = topicService.listTopic();
        model.addAttribute("topicList",topicList);
        return "publish";
    }

    //发帖
    @RequestMapping("/publishPost.do")
    public String publishPost(PostEntity post) {
        int id = postService.publishPost(post);
        return "redirect:toPost.do?pid="+id;
    }


    //按时间，倒序，列出帖子
    @RequestMapping("/listPostByTime.do")
    public String listPostByTime(int curPage,Model model){
        PageBean<PostEntity> pageBean = postService.listPostByTime(curPage);
        List<UserEntity> userList = userService.listUserByTime();
        List<UserEntity> hotUserList = userService.listUserByHot();
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("userList",userList);
        model.addAttribute("hotUserList",hotUserList);
        return "index";
    }

    //去帖子详情页面
    @RequestMapping("/toPost.do")
    public String toPost(int pid,Model model,HttpSession session){
        Integer sessionUid = (Integer) session.getAttribute("uid");
        //获取帖子信息
        PostEntity post = postService.getPostByPid(pid);
        //获取评论信息
        List<ReplyEntity> replyList = replyService.listReply(pid);

        //判断用户是否已经点赞

        boolean liked = false;
        if(sessionUid!=null){
            liked = postService.getLikeStatus(pid,sessionUid);
        }
        //向模型中添加数据
        model.addAttribute("post",post);
        model.addAttribute("replyList",replyList);
        model.addAttribute("liked",liked);
        return "post";
    }

    //异步点赞
    @RequestMapping(value = "/ajaxClickLike.do",produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String ajaxClickLike(int pid, HttpSession session){
        int sessionUid = (int) session.getAttribute("uid");
        return postService.clickLike(pid,sessionUid);
    }
}
