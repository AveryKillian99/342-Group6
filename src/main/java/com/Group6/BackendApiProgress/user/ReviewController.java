package com.Group6.BackendApiProgress.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // POST endpoint to add a review for a producer
    @PostMapping("/consumer/{consumerId}/producer/{producerId}")
    public ProducerReview addProducerReview(
            @PathVariable int consumerId,
            @PathVariable int producerId,
            @RequestBody ProducerReview review) {
        return reviewService.addProducerReview(consumerId, producerId, review);
    }

    // POST endpoint to add a review for a consumer
    @PostMapping("/producer/{producerId}/consumer/{consumerId}")
    public ConsumerReview addConsumerReview(
            @PathVariable int producerId,
            @PathVariable int consumerId,
            @RequestBody ConsumerReview review) {
        return reviewService.addConsumerReview(producerId, consumerId, review);
    }
}
