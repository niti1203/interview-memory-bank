package com.interviewbank.interview_memory_bank.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "interview_experiences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String role;

    private String difficulty;

    private String result;

    @Column(length = 5000)
    private String questions;

    @Column(length = 5000)
    private String overallExperience;
}