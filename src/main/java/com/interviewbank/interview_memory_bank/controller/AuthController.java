package com.interviewbank.interview_memory_bank.controller;

import com.interviewbank.interview_memory_bank.dto.LoginRequest;
import com.interviewbank.interview_memory_bank.dto.RegisterRequest;
import com.interviewbank.interview_memory_bank.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}