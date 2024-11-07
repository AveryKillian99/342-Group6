package com.Group6.BackendApiProgress.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerReviewRepository extends JpaRepository<ProducerReview, Integer> {
    // Optionally, add methods to find reviews by producer ID or other criteria
}
