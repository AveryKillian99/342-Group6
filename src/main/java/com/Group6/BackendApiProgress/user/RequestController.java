package com.Group6.BackendApiProgress.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private ProducerRepository producerRepository;

    // Get all active (Pending) requests
    @GetMapping("/active")
    public List<Request> getAllActiveRequests() {
        return requestService.getAllActiveRequests();
    }

    // Producer decides to take a request
    @PutMapping("/take/{requestId}/producer/{producerId}")
    public Request assignProducerToRequest(@PathVariable int requestId, @PathVariable int producerId) {
        // Fetch producer from database
        Producer producer = producerRepository.findById(producerId).orElse(null);

        if (producer == null) {
            // Producer not found, return a response indicating failure
            throw new RuntimeException("Producer not found with ID: " + producerId);
        }

        // Fetch the request from database
        Request request = requestService.getRequestById(requestId);

        if (request == null) {
            // Request not found, return a response indicating failure
            throw new RuntimeException("Request not found with ID: " + requestId);
        }

        // Assign the producer to the request and update status
        request.setProducer(producer);  // Set the producer to the request
        request.setStatus("assigned");  // Change the status of the request to assigned

        return requestService.saveRequest(request);  // Save the updated request
    }
}


