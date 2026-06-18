package com.interviewbank.interview_memory_bank.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @GetMapping("/company/{company}")
    public List<InterviewExperience> getByCompany(
            @PathVariable String company) {

        return service.getByCompany(company);
    }
    @GetMapping("/role/{role}")
    public List<InterviewExperience> getByRole(
            @PathVariable String role) {

        return service.getByRole(role);
    }
    @GetMapping("/user/{userId}")
    public List<InterviewExperience> getByUser(
            @PathVariable Long userId) {

        return service.getExperiencesByUser(userId);

    }

    @GetMapping("/paged")
    public Page<InterviewExperience> getAllExperiencesPaged(
            Pageable pageable) {

        return service.getAllExperiences(pageable);
    }

    @DeleteMapping("/{id}")
    public String deleteExperience(
            @PathVariable Long id) {

        return service.deleteExperience(id);
    }
    @PutMapping("/{id}")
    public String updateExperience(
            @PathVariable Long id,
            @RequestBody InterviewExperienceRequest request) {

        return service.updateExperience(id, request);
    }
}