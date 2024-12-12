package com.example.taxi_service.repository;

import com.example.taxi_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query method to find a user by username
    User findByUsername(String username);

    // Custom query method to find a user by email
    User findByEmail(String email);
}
