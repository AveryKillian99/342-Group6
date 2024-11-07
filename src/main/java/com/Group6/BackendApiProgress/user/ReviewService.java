package com.Group6.BackendApiProgress.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ProducerReviewRepository producerReviewRepository;

    @Autowired
    private ConsumerReviewRepository consumerReviewRepository;

    @Autowired
    private ConsumerRepository consumerRepository;

    @Autowired
    private ProducerRepository producerRepository;

    // Add a review for a producer by a consumer
    public ProducerReview addProducerReview(int consumerId, int producerId, ProducerReview review) {
        Consumer consumer = consumerRepository.findById(consumerId).orElse(null);
        Producer producer = producerRepository.findById(producerId).orElse(null);

        if (consumer == null || producer == null) {
            return null; // Consumer or producer not found
        }

        // Set the consumer and producer in the review
        review.setConsumer(consumer);
        review.setProducer(producer);

        // Save and return the review
        return producerReviewRepository.save(review);
    }

    // Add a review for a consumer by a producer
    public ConsumerReview addConsumerReview(int producerId, int consumerId, ConsumerReview review) {
        Consumer consumer = consumerRepository.findById(consumerId).orElse(null);
        Producer producer = producerRepository.findById(producerId).orElse(null);

        if (consumer == null || producer == null) {
            return null; // Consumer or producer not found
        }

        // Set the consumer and producer in the review
        review.setConsumer(consumer);
        review.setProducer(producer);

        // Save and return the review
        return consumerReviewRepository.save(review);
    }
}
