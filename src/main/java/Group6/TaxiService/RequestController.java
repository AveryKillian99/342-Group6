package Group6.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")

public class RequestController {

    @Autowired
    private RequestService service;

    // Get all requests
    @GetMapping
    public List<Request> getAllRequests() {
        return service.getAllRequests();
    }

    // Get a specific request by ID
    @GetMapping("/{requestId}")
    public Request getRequestById(@PathVariable int requestId) {
        return service.getRequestById(requestId);
    }

    // Add a new request
    @PostMapping("/new")
    public Request addNewRequest(@RequestBody Request request) {
        return service.addNewRequest(request);
    }

    // Update an existing request
    @PutMapping("/update/{requestId}")
    public Request updateRequest(@PathVariable int requestId, @RequestBody Request request) {
        return service.updateRequest(requestId, request);
    }

    // Delete a request by ID
    @DeleteMapping("/delete/{requestId}")
    public List<Request> deleteRequestById(@PathVariable int requestId) {
        service.deleteRequestById(requestId);
        return service.getAllRequests();
    }

    // Accept a request by ID
    @PutMapping("/accept/{requestId}")
    public Request acceptRequest(@PathVariable int requestId) {
        return service.acceptRequest(requestId);
    }
}
