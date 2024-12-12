package com.example.taxi_service.controller;

import com.example.taxi_service.entity.Review;
import com.example.taxi_service.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Endpoint to get all reviews for the UI
    @GetMapping
    public String getAllReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "review-list";  // Thymeleaf template for listing reviews
    }

    // Show form to add a new review
    @GetMapping("/add")
    public String showAddReviewForm(Model model) {
        model.addAttribute("review", new Review());  // Pass an empty review object for the form
        return "review-form";  // Thymeleaf form for adding a new review
    }

    // Handle POST request to create a review
    @PostMapping("/add")
    public String addReview(@ModelAttribute Review review) {
        reviewService.createReview(review);
        return "redirect:/reviews";  // Redirect to the review list after saving
    }

    // Show form to update an existing review
    @GetMapping("/update/{id}")
    public String showUpdateReviewForm(@PathVariable Long id, Model model) {
        Review review = reviewService.getReviewById(id);
        model.addAttribute("review", review);
        return "review-form";  // Thymeleaf form for updating the review
    }

    // Handle POST request to update the review status (allow/block)
    @PostMapping("/update/{id}")
    public String updateReview(@PathVariable Long id, @ModelAttribute Review review) {
        review.setId(id);  // Set the ID from the path variable
        reviewService.updateReviewStatus(id, review.getStatus());  // Update status
        return "redirect:/reviews";  // Redirect back to the review list
    }

    // Handle request to delete a review
    @GetMapping("/delete/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "redirect:/reviews";  // Redirect to the review list
    }

    // API endpoints for JSON responses (if needed)
    @GetMapping("/api")
    public ResponseEntity<List<Review>> getAllReviewsApi() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/api")
    public ResponseEntity<Review> createReviewApi(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
    }

    @PutMapping("/api/{id}/status/{status}")
    public ResponseEntity<Review> updateReviewStatusApi(@PathVariable Long id, @PathVariable String status) {
        Review updatedReview = reviewService.updateReviewStatus(id, status);
        if (updatedReview != null) {
            return ResponseEntity.ok(updatedReview);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<Void> deleteReviewApi(@PathVariable Long id) {
        boolean isDeleted = reviewService.deleteReview(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
