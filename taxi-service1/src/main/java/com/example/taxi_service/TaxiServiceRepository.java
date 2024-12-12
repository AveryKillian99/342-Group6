package com.example.taxi_service.repository;

import com.example.taxi_service.entity.TaxiService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiServiceRepository extends JpaRepository<TaxiService, Long> {
}
