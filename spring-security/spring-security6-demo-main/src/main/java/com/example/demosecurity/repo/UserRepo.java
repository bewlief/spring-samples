package com.example.demosecurity.repo;

import com.example.demosecurity.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<AppUser, String> {
    Optional<AppUser> findByEmail(String email);
}
