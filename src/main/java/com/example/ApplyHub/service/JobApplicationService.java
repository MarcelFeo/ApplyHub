package com.example.ApplyHub.service;

import com.example.ApplyHub.domain.ApplicationStatus;
import com.example.ApplyHub.domain.JobApplication;
import com.example.ApplyHub.domain.User;
import com.example.ApplyHub.repositories.JobApplicationRepository;
import com.example.ApplyHub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository repository;

    @Autowired
    private UserRepository userRepository;

    public JobApplication createJob(Long userId, JobApplication job) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        job.setUser(user);
        job.setAppliedAt(LocalDateTime.now());
        job.setStatus(ApplicationStatus.APPLIED);

        return repository.save(job);

    }

    public List<JobApplication> listUserJobs(Long userId) { return repository.findByUserId(userId); }

    public JobApplication updateStatus(Long jobId, ApplicationStatus status) {

        JobApplication job = repository.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));

        job.setStatus(status);

        return repository.save(job);

    }

    public void deleteJob(Long jobId) { repository.deleteById(jobId); }

}
