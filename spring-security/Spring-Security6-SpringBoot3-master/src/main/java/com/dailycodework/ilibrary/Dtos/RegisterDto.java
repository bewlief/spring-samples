package com.dailycodework.ilibrary.Dtos;

import com.dailycodework.ilibrary.Entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private long id;
    private String name;
    private String username;
    private String email;
    private String password;
}
