package com.njs.webdiary.interceptor;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter
{
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*").excludePathPatterns("/toIndex.do","/upload.do","/toLogin.do","/register.do","/login.do","/activate.do","/logout.do","/toPost.do","/listTopic.do","/listPostByTime.do",
                "/forgetPassword.do","/afterForgetPassword.do","/verify.do","/listImage.do");
        super.addInterceptors(registry);
    }
}
