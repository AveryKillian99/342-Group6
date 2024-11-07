package com.Group6.BackendApiProgress.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class ProducerReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reviewId;

    @Column(nullable = false)
    private String reviewContent;

    @Column(nullable = false)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "consumer_id", referencedColumnName = "consumerId")
    private Consumer consumer;  // Consumer reviewing the producer

    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "producerId")
    @JsonBackReference
    private Producer producer;  // Producer being reviewed

    // Constructors, Getters, and Setters
    public ProducerReview() {}

    public ProducerReview(String reviewContent, int rating, Consumer consumer, Producer producer) {
        this.reviewContent = reviewContent;
        this.rating = rating;
        this.consumer = consumer;
        this.producer = producer;
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

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
