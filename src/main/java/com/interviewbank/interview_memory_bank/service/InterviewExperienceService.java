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

    public List<InterviewExperience> getByCompany(String companyName) {
        return repository.findByCompanyName(companyName);
    }

    public List<InterviewExperience> getByRole(String role) {
        return repository.findByRole(role);
    }

    public String deleteExperience(Long id) {

        repository.deleteById(id);

        return "Experience Deleted Successfully";
    }

    public String updateExperience(Long id,
                                   InterviewExperienceRequest request) {

        InterviewExperience experience =
                repository.findById(id)
                        .orElseThrow();

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
}

