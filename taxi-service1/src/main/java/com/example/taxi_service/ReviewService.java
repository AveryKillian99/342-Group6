package com.example.taxi_service.service;

import com.example.taxi_service.entity.Review;
import com.example.taxi_service.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Get all reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Update the status of a review (e.g., for flagging inappropriate content)
    public Review updateReviewStatus(Long id, String status) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isPresent()) {
            Review existingReview = review.get();
            existingReview.setStatus(status);
            return reviewRepository.save(existingReview);
        }
        return null;  // Or throw an exception if preferred
    }

    // Delete a review
    public boolean deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Create a new review
    public Review createReview(Review review) {
        return reviewRepository.save(review);  // Save the review to the database
    }

    // Get a review by its ID
    public Review getReviewById(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.orElse(null);  // Return null if the review is not found, or you can throw an exception
    }
}
