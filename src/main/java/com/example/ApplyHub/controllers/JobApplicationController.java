package com.example.ApplyHub.controllers;

import com.example.ApplyHub.domain.ApplicationStatus;
import com.example.ApplyHub.domain.JobApplication;
import com.example.ApplyHub.domain.User;
import com.example.ApplyHub.dto.JobResponse;
import com.example.ApplyHub.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobApplicationController {

    @Autowired
    private JobApplicationService service;

    @PostMapping
    public ResponseEntity<JobResponse> create(
            @RequestBody JobApplication job,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();
        JobApplication jobObject = service.createJob(user.getId(), job);

        return ResponseEntity.ok(
                new JobResponse(
                        job.getId(),
                        job.getCompany(),
                        job.getPosition(),
                        job.getResume(),
                        job.getStatus(),
                        job.getAppliedAt()
                )
        );
    }

    // LISTAR VAGAS DO USUÁRIO LOGADO
    @GetMapping
    public ResponseEntity<List<JobResponse>> list(Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        List<JobApplication> jobs = service.listUserJobs(user);

        List<JobResponse> response = jobs.stream()
                .map(job -> new JobResponse(
                        job.getId(),
                        job.getCompany(),
                        job.getPosition(),
                        job.getResume(),
                        job.getStatus(),
                        job.getAppliedAt()
                ))
                .toList();

        return ResponseEntity.ok(response);
    }

    // ATUALIZAR STATUS (SOMENTE SE FOR DO USUÁRIO)
    @PutMapping("/{jobId}")
    public ResponseEntity<JobResponse> updateStatus(
            @PathVariable Long jobId,
            @RequestParam ApplicationStatus status,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        JobApplication updated = service.updateStatus(user, jobId, status);

        return ResponseEntity.ok(mapToResponse(updated));
    }

    // DELETAR (SOMENTE SE FOR DO USUÁRIO)
    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long jobId,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        service.deleteJob(user, jobId);

        return ResponseEntity.noContent().build();
    }

    private JobResponse mapToResponse(JobApplication job) {
        return new JobResponse(
                job.getId(),
                job.getCompany(),
                job.getPosition(),
                job.getResume(),
                job.getStatus(),
                job.getAppliedAt()
        );
    }

}
