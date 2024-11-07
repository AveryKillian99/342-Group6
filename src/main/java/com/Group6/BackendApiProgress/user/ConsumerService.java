package com.Group6.BackendApiProgress.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerService {

    @Autowired
    private ConsumerRepository consumerRepository;

    @Autowired
    private RequestRepository requestRepository;

    // Add a new consumer
    public Consumer addNewConsumer(Consumer consumer) {
        return consumerRepository.save(consumer);
    }

    // Get all consumers
    public List<Consumer> getAllConsumers() {
        return consumerRepository.findAll();
    }

    // Get a consumer by ID
    public Consumer getConsumerById(int consumerId) {
        Optional<Consumer> consumer = consumerRepository.findById(consumerId);
        return consumer.orElse(null);
    }

    // Add a request to a consumer
    public Request addRequest(int consumerId, Request request) {
        Consumer consumer = getConsumerById(consumerId);
        if (consumer != null) {
            request.setConsumer(consumer);  // Set the request to be linked to this consumer
            return requestRepository.save(request);
        }
        return null;  // Return null if consumer doesn't exist
    }

    // Get all requests by a consumer
    public List<Request> getRequestsByConsumer(int consumerId) {
        Consumer consumer = getConsumerById(consumerId);
        if (consumer != null) {
            return consumer.getRequests();
        }
        return null;
    }


    public Consumer updateConsumer(int consumerId, Consumer updatedConsumer) {
        // Retrieve the consumer by ID
        Consumer existingConsumer = consumerRepository.findById(consumerId)
                .orElseThrow(() -> new RuntimeException("Consumer not found"));

        // Update fields
        if (updatedConsumer.getConsumerName() != null) {
            existingConsumer.setConsumerName(updatedConsumer.getConsumerName());
        }

        // Save and return the updated consumer
        return consumerRepository.save(existingConsumer);
    }
}

