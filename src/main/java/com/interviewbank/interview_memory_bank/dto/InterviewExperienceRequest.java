package com.interviewbank.interview_memory_bank.dto;

import lombok.Data;

@Data
public class InterviewExperienceRequest {

    private Long userId;
    private String companyName;
    private String role;
    private String difficulty;
    private String result;
    private String questions;
    private String overallExperience;
}