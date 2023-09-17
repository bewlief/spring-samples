package com.dailycodework.ilibrary.Service;

import com.dailycodework.ilibrary.Dtos.LoginDto;
import com.dailycodework.ilibrary.Dtos.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
