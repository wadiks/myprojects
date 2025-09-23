package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HealthService {

    @GetMapping("/health")
    public String health() {
        return "{\"status\": \"OK\"}";
    }

    public static void main(String[] args) {
        SpringApplication.run(HealthService.class, args);
    }
}