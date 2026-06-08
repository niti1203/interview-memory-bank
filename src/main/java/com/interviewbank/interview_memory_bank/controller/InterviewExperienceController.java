package com.interviewbank.interview_memory_bank.controller;

import com.interviewbank.interview_memory_bank.dto.InterviewExperienceRequest;
import com.interviewbank.interview_memory_bank.entity.InterviewExperience;
import com.interviewbank.interview_memory_bank.service.InterviewExperienceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
public class InterviewExperienceController {

    private final InterviewExperienceService service;

    public InterviewExperienceController(
            InterviewExperienceService service) {
        this.service = service;
    }

    @PostMapping
    public String addExperience(
            @RequestBody InterviewExperienceRequest request) {

        return service.addExperience(request);
    }

    @GetMapping
    public List<InterviewExperience> getAllExperiences() {
        return service.getAllExperiences();
    }

    @GetMapping("/{id}")
    public InterviewExperience getExperienceById(
            @PathVariable Long id) {

        return service.getExperienceById(id);
    }
}