package com.interviewbank.interview_memory_bank.service;

import com.interviewbank.interview_memory_bank.dto.InterviewExperienceRequest;
import com.interviewbank.interview_memory_bank.entity.InterviewExperience;
import com.interviewbank.interview_memory_bank.repository.InterviewExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewExperienceService {

    private final InterviewExperienceRepository repository;

    public InterviewExperienceService(
            InterviewExperienceRepository repository) {
        this.repository = repository;
    }

    public String addExperience(
            InterviewExperienceRequest request) {

        InterviewExperience experience =
                InterviewExperience.builder()
                        .companyName(request.getCompanyName())
                        .role(request.getRole())
                        .difficulty(request.getDifficulty())
                        .result(request.getResult())
                        .questions(request.getQuestions())
                        .overallExperience(request.getOverallExperience())
                        .build();

        repository.save(experience);

        return "Experience Added Successfully";
    }

    public List<InterviewExperience> getAllExperiences() {
        return repository.findAll();
    }

    public InterviewExperience getExperienceById(Long id) {
        return repository.findById(id).orElse(null);
    }
}