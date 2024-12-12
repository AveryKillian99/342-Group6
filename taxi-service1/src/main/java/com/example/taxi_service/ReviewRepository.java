package com.example.taxi_service.repository;

import com.example.taxi_service.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // No additional methods needed for basic CRUD
}
