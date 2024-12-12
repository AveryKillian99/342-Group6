package com.example.taxi_service.controller;

import com.example.taxi_service.entity.TaxiService;
import com.example.taxi_service.service.TaxiServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class TaxiServiceController {

    @Autowired
    private TaxiServiceService taxiServiceService;

    @GetMapping
    public List<TaxiService> getAllServices() {
        return taxiServiceService.getAllServices();
    }

    @PostMapping
    public ResponseEntity<TaxiService> createService(@RequestBody TaxiService taxiService) {
        TaxiService createdService = taxiServiceService.saveService(taxiService);
        return ResponseEntity.ok(createdService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        taxiServiceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}

