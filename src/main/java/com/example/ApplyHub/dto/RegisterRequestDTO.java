package com.example.ApplyHub.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RegisterRequestDTO(
        String name,
        String email,
        String username,
        String password,
        String phone,
        String linkedinUrl,
        String bio,
        LocalDate birthDate
) {}