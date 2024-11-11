package com.example.taxi_service.controller;

import com.example.taxi_service.entity.TaxiService;  // Updated import
import com.example.taxi_service.service.TaxiServiceService;  // Updated import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")  // API endpoint for services
public class TaxiServiceController {

    @Autowired
    private TaxiServiceService taxiServiceService;

    // Endpoint to get all services
    @GetMapping
    public ResponseEntity<List<TaxiService>> getAllServices() {
        List<TaxiService> services = taxiServiceService.getAllServices();
        return ResponseEntity.ok(services);
    }

    // Endpoint to get a service by name
    @GetMapping("/{name}")
    public ResponseEntity<TaxiService> getServiceByName(@PathVariable String name) {
        TaxiService service = taxiServiceService.getServiceByName(name);
        if (service != null) {
            return ResponseEntity.ok(service);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // Endpoint to create or update a service
    @PostMapping
    public ResponseEntity<TaxiService> createService(@RequestBody TaxiService taxiService) {
        TaxiService createdService = taxiServiceService.saveService(taxiService);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdService);
    }

    // Endpoint to update service status (e.g., to flag, activate, deactivate)
    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<TaxiService> updateServiceStatus(@PathVariable Long id, @PathVariable String status) {
        TaxiService updatedService = taxiServiceService.updateServiceStatus(id, status);
        if (updatedService != null) {
            return ResponseEntity.ok(updatedService);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Endpoint to delete a service
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        boolean isDeleted = taxiServiceService.deleteService(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
