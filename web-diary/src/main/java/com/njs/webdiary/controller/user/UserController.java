package com.njs.webdiary.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
public class UserController {

    @RequestMapping("/user")
    public String userRequest(){
        return "hello";
    }
}
