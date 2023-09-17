package com.example.springsecurity.controller;

import com.example.springsecurity.entity.user;
import com.example.springsecurity.service.impl.LoginService;
import com.example.springsecurity.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/hello")
    @PreAuthorize("@ss.hasPermi('sys:user:hello')")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/login")
    public AjaxResult login(user user){
        AjaxResult ajax = AjaxResult.success();
        System.out.println("输出内容");
        // 生成令牌
        String token = loginService.login(user.getName(), user.getPasswore());
        ajax.put("token", token);
        return ajax;
    }
}
