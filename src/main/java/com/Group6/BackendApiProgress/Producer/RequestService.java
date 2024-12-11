package com.Group6.BackendApiProgress.Producer;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RequestService {

    @Autowired
    private RequestRepository repository;

    public List<Request> getAllRequests() {
        return repository.findAll();
    }

    public Request getRequestById(int requestId) {
        return repository.findById(requestId).orElse(null);
    }

    public Request addNewRequest(Request request) {
        return repository.save(request);
    }

    public Request updateRequest(int requestId, Request updatedRequest) {
        Optional<Request> optionalRequest = repository.findById(requestId);
        if (optionalRequest.isPresent()) {
            Request existingRequest = optionalRequest.get();
            existingRequest.setRequestDetails(updatedRequest.getRequestDetails());
            existingRequest.setCustomerName(updatedRequest.getCustomerName());
            return repository.save(existingRequest);
        }
        return null;
    }

    public void deleteRequestById(int requestId) {
        repository.deleteById(requestId);
    }

    public Request acceptRequest(int requestId) {
        Optional<Request> optionalRequest = repository.findById(requestId);
        if (optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            request.setAccepted(true); // Mark the request as accepted
            return repository.save(request);
        }
        return null;
    }
}

