package com.example.ApplyHub.repositories;

import com.example.ApplyHub.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>{

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long userId);

}
