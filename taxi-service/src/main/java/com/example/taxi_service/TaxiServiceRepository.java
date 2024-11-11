package com.example.taxi_service.repository;

import com.example.taxi_service.entity.TaxiService;  // Updated import
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiServiceRepository extends JpaRepository<TaxiService, Long> {
    // You can add custom query methods here if needed
    TaxiService findByName(String name);  // Example method for finding service by name
}
