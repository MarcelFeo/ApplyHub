package com.example.ApplyHub.controllers;

import com.example.ApplyHub.domain.ApplicationStatus;
import com.example.ApplyHub.domain.JobApplication;
import com.example.ApplyHub.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobApplicationController {

    @Autowired
    private JobApplicationService service;

    @PostMapping("/{userId}")
    public ResponseEntity<JobApplication> create(@PathVariable Long userId, @RequestBody JobApplication job) {
        return ResponseEntity.ok(service.createJob(userId, job));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<JobApplication>> list(@PathVariable Long userId) {
        return ResponseEntity.ok(service.listUserJobs(userId));
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<JobApplication> updateStatus(@PathVariable Long jobId, @RequestParam ApplicationStatus status) {
        return ResponseEntity.ok(service.updateStatus(jobId, status));
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> delete(@PathVariable Long jobId) {
        service.deleteJob(jobId);
        return ResponseEntity.noContent().build();
    }

}
