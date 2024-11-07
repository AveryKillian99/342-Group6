package com.Group6.BackendApiProgress.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    // Create a new consumer
    @PostMapping("/new")
    public Consumer addNewConsumer(@RequestBody Consumer consumer) {
        return consumerService.addNewConsumer(consumer);
    }

    // Get all consumers
    @GetMapping("/all")
    public List<Consumer> getAllConsumers() {
        return consumerService.getAllConsumers();
    }

    // Get a specific consumer by ID
    @GetMapping("/{consumerId}")
    public Consumer getConsumerById(@PathVariable int consumerId) {
        return consumerService.getConsumerById(consumerId);
    }

    // Create a request for a specific consumer
    @PostMapping("/{consumerId}/request")
    public Request addRequest(@PathVariable int consumerId, @RequestBody Request request) {
        return consumerService.addRequest(consumerId, request);
    }

    // Get all requests made by a consumer
    @GetMapping("/{consumerId}/requests")
    public List<Request> getRequestsByConsumer(@PathVariable int consumerId) {
        return consumerService.getRequestsByConsumer(consumerId);
    }

    @PutMapping("/update/{consumerId}")
    public Consumer updateConsumer(@PathVariable int consumerId, @RequestBody Consumer updatedConsumer) {
        return consumerService.updateConsumer(consumerId, updatedConsumer);
    }

}
