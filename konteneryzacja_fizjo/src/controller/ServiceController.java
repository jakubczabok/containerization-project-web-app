package com.example.demo.controller;

import com.example.demo.model.Services;
import com.example.demo.service.ServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3004")
@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public ResponseEntity<List<Services>> getAllServices() {
        List<Services> services = serviceService.getAllServices();
        return ResponseEntity.ok(services);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Services> getServiceByName(@PathVariable String name) {
        Services service = serviceService.getServiceByName(name);
        return ResponseEntity.ok(service);
    }
    @PostMapping
    public ResponseEntity<Services> createBlogPost(@RequestBody Services service) {
        Services createdService= serviceService.createService(service);
        return ResponseEntity.ok(createdService);
    }
}
