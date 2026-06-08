package com.interviewbank.interview_memory_bank.service;

import com.interviewbank.interview_memory_bank.dto.LoginRequest;
import com.interviewbank.interview_memory_bank.dto.RegisterRequest;
import com.interviewbank.interview_memory_bank.entity.User;
import com.interviewbank.interview_memory_bank.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {
            return "User not found";
        }

        if (passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )) {
            return "Login Successful";
        }

        return "Invalid Password";
    }

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);

        return "User Registered Successfully";
    }
}
