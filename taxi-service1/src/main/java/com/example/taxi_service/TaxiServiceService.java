package com.example.taxi_service.service;

import com.example.taxi_service.entity.TaxiService;
import com.example.taxi_service.repository.TaxiServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxiServiceService {

    @Autowired
    private TaxiServiceRepository taxiServiceRepository;

    public List<TaxiService> getAllServices() {
        return taxiServiceRepository.findAll();
    }

    public TaxiService saveService(TaxiService taxiService) {
        return taxiServiceRepository.save(taxiService);
    }

    public void deleteService(Long id) {
        taxiServiceRepository.deleteById(id);
    }
}
