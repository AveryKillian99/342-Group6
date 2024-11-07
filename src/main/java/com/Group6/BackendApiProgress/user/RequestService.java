package com.Group6.BackendApiProgress.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public List<Request> getAllActiveRequests() {
        // Return all requests that are active
        return requestRepository.findByStatus("active");
    }

    public Request getRequestById(int requestId) {
        // Fetch the request by ID
        return requestRepository.findById(requestId).orElse(null);
    }

    public Request saveRequest(Request request) {
        // Save and return the updated request
        return requestRepository.save(request);
    }
}
