package com.example.demosecurity;

import com.example.demosecurity.models.AppUser;
import com.example.demosecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UnProtectedController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(userService.addUser(appUser));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(userService.login(appUser));
    }

    @RequestMapping
    public String get() {
        return "Hello from unprotected API method!";
    }
}
