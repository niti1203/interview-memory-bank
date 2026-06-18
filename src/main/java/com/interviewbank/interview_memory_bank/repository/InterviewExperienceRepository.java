package com.interviewbank.interview_memory_bank.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.interviewbank.interview_memory_bank.entity.InterviewExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewExperienceRepository
        extends JpaRepository<InterviewExperience, Long> {

    List<InterviewExperience> findByCompanyName(String companyName);

    List<InterviewExperience> findByRole(String role);

    Page<InterviewExperience> findAll(Pageable pageable);

    List<InterviewExperience> findByUserId(Long userId);
}