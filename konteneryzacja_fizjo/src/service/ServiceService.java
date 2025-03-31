package com.example.demo.service;

import com.example.demo.model.Services;
import com.example.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    // Wyszukiwanie usługi po nazwie
    public Services getServiceByName(String name) {
        return serviceRepository.findByName(name);
    }

    // Wyszukiwanie usług dostępnych w zadanym przedziale cenowym
    public List<Services> getServicesInPriceRange(Double minPrice, Double maxPrice) {
        return serviceRepository.findByPriceBetween(minPrice, maxPrice);
    }

    // Dodawanie nowej usługi
    public Services createService(Services service) {
        return serviceRepository.save(service);
    }

    // Możliwość aktualizacji danych usługi (np. zmiana statusu)
    public Services updateService(Long serviceId, Services updatedService) {
        // Najpierw sprawdzamy, czy usługa istnieje
        if (serviceRepository.existsById(serviceId)) {
            updatedService.setId(serviceId);
            return serviceRepository.save(updatedService);
        } else {
            throw new RuntimeException("Service not found");
        }
    }

    // Wyszukiwanie usług według statusu (np. aktywne, nieaktywne)
    public List<Services> getServicesByStatus(String status) {
        return serviceRepository.findByStatus(status);
    }

     // Pobieranie wszystkich usług
    public List<Services> getAllServices() {
        return serviceRepository.findAll();
    }
}
