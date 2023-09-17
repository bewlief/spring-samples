package com.example.springsecurity.service.impl;

import com.example.springsecurity.entity.user;
import org.springframework.stereotype.Service;

@Service
public class userService {
    public user findUserByName(){
        user user=new user();
        user.setId(0);
        user.setName("姓名");
        user.setPasswore("{bcrypt}$2a$10$UUbMgKe4ozOFfcfJcC6KoOQHLixmMNF.Evx.E5/AkidUExBGXuq6m");
        return user;
    }
}
