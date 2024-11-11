package com.example.taxi_service.service;

import com.example.taxi_service.entity.TaxiService;  // Updated import
import com.example.taxi_service.repository.TaxiServiceRepository;  // Updated import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // Service annotation for the business logic
public class TaxiServiceService {

    @Autowired
    private TaxiServiceRepository taxiServiceRepository;

    // Get all services
    public List<TaxiService> getAllServices() {
        return taxiServiceRepository.findAll();
    }

    // Get a service by name
    public TaxiService getServiceByName(String name) {
        return taxiServiceRepository.findByName(name);
    }

    // Create or update service
    public TaxiService saveService(TaxiService taxiService) {
        return taxiServiceRepository.save(taxiService);
    }

    // Update service status (e.g., ban or activate)
    public TaxiService updateServiceStatus(Long id, String status) {
        Optional<TaxiService> serviceOpt = taxiServiceRepository.findById(id);
        if (serviceOpt.isPresent()) {
            TaxiService taxiService = serviceOpt.get();
            taxiService.setStatus(status);
            return taxiServiceRepository.save(taxiService);
        }
        return null;  // Handle if service is not found
    }

    // Delete service
    public boolean deleteService(Long id) {
        if (taxiServiceRepository.existsById(id)) {
            taxiServiceRepository.deleteById(id);
            return true;
        }
        return false;  // Return false if the service wasn't found
    }
}
