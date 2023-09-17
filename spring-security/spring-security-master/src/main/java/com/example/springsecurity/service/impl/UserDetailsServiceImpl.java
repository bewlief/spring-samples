package com.example.springsecurity.service.impl;

import com.example.springsecurity.entity.impl.LoginUser;
import com.example.springsecurity.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private userService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user user = userService.findUserByName();
        Set<String> perms = new HashSet<String>();
        perms.add("sys:user:hello");
        return new LoginUser((long) user.getId(),user, perms);
    }
}
