package com.interviewbank.interview_memory_bank.service;

import com.interviewbank.interview_memory_bank.dto.InterviewExperienceRequest;
import com.interviewbank.interview_memory_bank.entity.InterviewExperience;
import com.interviewbank.interview_memory_bank.entity.User;
import com.interviewbank.interview_memory_bank.repository.InterviewExperienceRepository;
import com.interviewbank.interview_memory_bank.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Service


public class InterviewExperienceService {

    private final InterviewExperienceRepository repository;
    private final UserRepository userRepository;

    public InterviewExperienceService(
            InterviewExperienceRepository repository,
            UserRepository userRepository) {

        this.repository = repository;
        this.userRepository = userRepository;
    }

    public String addExperience(
            InterviewExperienceRequest request) {

        User user = userRepository
                .findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        InterviewExperience experience =
                InterviewExperience.builder()
                        .companyName(request.getCompanyName())
                        .role(request.getRole())
                        .difficulty(request.getDifficulty())
                        .result(request.getResult())
                        .questions(request.getQuestions())
                        .overallExperience(request.getOverallExperience())
                        .user(user)
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

    public List<InterviewExperience> getByCompany(String companyName) {
        return repository.findByCompanyName(companyName);
    }

    public List<InterviewExperience> getByRole(String role) {
        return repository.findByRole(role);
    }

    public List<InterviewExperience> getExperiencesByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public Page<InterviewExperience> getAllExperiences(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public String updateExperience(
            Long id,
            InterviewExperienceRequest request) {


        InterviewExperience experience =
                repository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Experience not found"));

        experience.setCompanyName(request.getCompanyName());
        experience.setRole(request.getRole());
        experience.setDifficulty(request.getDifficulty());
        experience.setResult(request.getResult());
        experience.setQuestions(request.getQuestions());
        experience.setOverallExperience(
                request.getOverallExperience());

        repository.save(experience);

        return "Experience Updated Successfully";
    }

    public String deleteExperience(Long id) {

        repository.deleteById(id);

        return "Experience Deleted Successfully";
    }
}