package com.example.demo.repository;

import com.example.demo.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {

    // Wyszukiwanie po nazwie usługi
    Services findByName(String name);

    // Wyszukiwanie usług, które są aktywne (np. status 'aktywny' w polu status)
    List<Services> findByStatus(String status);

    // Wyszukiwanie usług, które są dostępne w określonym przedziale cenowym
    List<Services> findByPriceBetween(Double minPrice, Double maxPrice);
    
    // Wyszukiwanie usług, które zawierają dany fragment w nazwie (np. "rehabilitacja kręgosłupa")
    List<Services> findByNameContaining(String nameFragment);
}
