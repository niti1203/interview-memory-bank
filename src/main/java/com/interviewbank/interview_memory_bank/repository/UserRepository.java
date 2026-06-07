package com.interviewbank.interview_memory_bank.repository;

import com.interviewbank.interview_memory_bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}