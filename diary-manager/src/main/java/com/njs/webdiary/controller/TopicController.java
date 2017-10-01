package com.njs.webdiary.controller;


import com.njs.webdiary.entity.TopicEntity;
import com.njs.webdiary.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class TopicController {

    @Autowired
    private TopicService topicService;

    /**
     * 列出所有话题
     * @param model
     * @return
     */
    @RequestMapping("/listTopic.do")
    public String listTopic(Model model){
        List<TopicEntity> topicList = topicService.listTopic();
        model.addAttribute("topicList",topicList);
        return "topic";
    }

    @RequestMapping("/listImage.do")
    public String listImage(Model model){
        List<String> imageList = topicService.listImage();
        model.addAttribute("imageList",imageList);
        return "image";
    }
}





