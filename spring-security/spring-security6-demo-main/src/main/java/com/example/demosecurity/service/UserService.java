package com.example.demosecurity.service;

import com.example.demosecurity.jwt.JwtService;
import com.example.demosecurity.models.AppUser;
import com.example.demosecurity.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public AppUser addUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return userRepo.save(appUser);
    }

    public Map<String, String> login(AppUser appUser) {
        String token = jwtService.generateToken(appUser);
        return Map.of("token", token);
    }
}
