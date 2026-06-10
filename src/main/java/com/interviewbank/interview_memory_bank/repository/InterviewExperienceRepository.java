package com.interviewbank.interview_memory_bank.repository;

import com.interviewbank.interview_memory_bank.entity.InterviewExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewExperienceRepository
        extends JpaRepository<InterviewExperience, Long> {

    List<InterviewExperience> findByCompanyName(String companyName);

    List<InterviewExperience> findByRole(String role);
}