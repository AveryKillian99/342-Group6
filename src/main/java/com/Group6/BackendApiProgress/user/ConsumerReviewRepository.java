package com.Group6.BackendApiProgress.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerReviewRepository extends JpaRepository<ConsumerReview, Integer> {
    // Custom queries can be added here (if necessary)
}
