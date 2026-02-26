package com.example.ApplyHub.repositories;

import com.example.ApplyHub.domain.JobApplication;
import com.example.ApplyHub.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findByUserId(Long userId);

    Optional<JobApplication> findById(Long userId);

}
