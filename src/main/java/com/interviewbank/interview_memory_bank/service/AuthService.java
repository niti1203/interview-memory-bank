package com.interviewbank.interview_memory_bank.service;

import com.interviewbank.interview_memory_bank.dto.RegisterRequest;
import com.interviewbank.interview_memory_bank.entity.User;
import com.interviewbank.interview_memory_bank.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(RegisterRequest request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        userRepository.save(user);

        return "User Registered Successfully";
    }
}