package com.example.ApplyHub.dto;

import com.example.ApplyHub.domain.ApplicationStatus;

import java.time.LocalDateTime;

public record JobResponse(

   Long id,
   String company,
   String position,
   String resume,
   ApplicationStatus status,
   LocalDateTime appliedAt

) {}
