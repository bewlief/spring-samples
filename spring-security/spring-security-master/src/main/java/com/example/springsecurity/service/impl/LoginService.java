package com.example.springsecurity.service.impl;

import com.example.springsecurity.entity.impl.LoginUser;
import com.example.springsecurity.utils.JWTutil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class LoginService {

    @Autowired
    private JWTutil jwTutil;

    @Resource
    private AuthenticationManager authenticationManager;


    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    public String login(String username, String password) {

        // 用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            System.out.println(e);
        }

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 生成token
        return jwTutil.createToken(loginUser);
    }


}
