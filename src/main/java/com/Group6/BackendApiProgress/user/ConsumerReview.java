package com.Group6.BackendApiProgress.user;

import jakarta.persistence.*;

@Entity
public class ConsumerReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reviewId;

    @Column(nullable = false)
    private String reviewContent;

    @Column(nullable = false)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "producerId")
    private Producer producer;  // Producer reviewing the consumer

    @ManyToOne
    @JoinColumn(name = "consumer_id", referencedColumnName = "consumerId")
    private Consumer consumer;  // Consumer being reviewed

    // Constructors, Getters, and Setters
    public ConsumerReview() {}

    public ConsumerReview(String reviewContent, int rating, Producer producer, Consumer consumer) {
        this.reviewContent = reviewContent;
        this.rating = rating;
        this.producer = producer;
        this.consumer = consumer;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
}
