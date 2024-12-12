package com.example.taxi_service;

import org.springframework.web.bind.annotation.GetMapping;

public class ServicePageController {

    @GetMapping("/services")
    public String getServicesPage() {
        return "services";  // This corresponds to /src/main/resources/templates/services.html
    }
}
