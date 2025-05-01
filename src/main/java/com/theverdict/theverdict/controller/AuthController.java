package com.theverdict.theverdict.controller;

import com.theverdict.theverdict.dto.AuthRequest;
import com.theverdict.theverdict.dto.AuthResponse;
import com.theverdict.theverdict.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        authService.register(request);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }
}
