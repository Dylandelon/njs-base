package com.njs.webdiary.controller;


import com.njs.webdiary.entity.MessageEntity;
import com.njs.webdiary.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MessageController {


    @Autowired
    private MessageService messageService;

    //去消息页面
    @RequestMapping("/toMessage.do")
    public String toMessage(Model model, HttpSession session) {
        Integer sessionUid = (Integer) session.getAttribute("uid");
        Map<String,List<MessageEntity>> map = messageService.findAll(sessionUid);
        model.addAttribute("map",map);
        System.out.println(map);
        return "message";
    }

}
