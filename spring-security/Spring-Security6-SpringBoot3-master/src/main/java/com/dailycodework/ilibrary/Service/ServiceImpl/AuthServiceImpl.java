package com.dailycodework.ilibrary.Service.ServiceImpl;

import com.dailycodework.ilibrary.Dtos.JwtAuthResponse;
import com.dailycodework.ilibrary.Dtos.LoginDto;
import com.dailycodework.ilibrary.Dtos.RegisterDto;
import com.dailycodework.ilibrary.Entity.Role;
import com.dailycodework.ilibrary.Entity.User;
import com.dailycodework.ilibrary.Repository.RoleRepository;
import com.dailycodework.ilibrary.Repository.UserRepository;
import com.dailycodework.ilibrary.Security.JwtTokenProvider;
import com.dailycodework.ilibrary.Service.AuthService;
import com.dailycodework.ilibrary.exception.BookAPIException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {
//        check if user already exist in database
        if (userRepository.existsByEmail(registerDto.getEmail())){
            throw new BookAPIException("User already exist with the email",HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByUsername(registerDto.getUsername())){
            throw new BookAPIException("User already exist with the name", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());

        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
        return "User Registered Successfully";
    }

}
