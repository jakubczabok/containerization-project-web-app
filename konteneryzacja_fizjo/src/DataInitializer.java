package com.example.demo;

import com.example.demo.model.BlogPost;
import com.example.demo.model.Services;

import com.example.demo.repository.BlogPostRepository;
import com.example.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BlogPostRepository blogPostRepository;
    private final ServiceRepository serviceRepository;

    @Autowired
    public DataInitializer(BlogPostRepository blogPostRepository, 
                           ServiceRepository serviceRepository) {
        this.blogPostRepository = blogPostRepository;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
   
        // Dodanie domyślnych danych do tabeli blogposts
        if (blogPostRepository.count() == 0) {
            blogPostRepository.save(new BlogPost(
                    "Wprowadzenie do fizjoterapii", 
                    "Fizjoterapia to dziedzina medycyny, która zajmuje się leczeniem schorzeń narządu ruchu. Celem fizjoterapii jest poprawa sprawności fizycznej i łagodzenie bólu.",
                    "Jan Kowalski", 
                    LocalDateTime.now(), 
                    LocalDateTime.now(), 
                    LocalDateTime.of(2025, 2, 6, 9, 0), 
                    Arrays.asList("fizjoterapia", "zdrowie", "rehabilitacja"), 
                    "opublikowany"
            ));
            blogPostRepository.save(new BlogPost(
                    "Korzyści z fizjoterapii", 
                    "Fizjoterapia przynosi wiele korzyści, m.in. łagodzenie bólu, poprawę ruchomości stawów oraz przyspieszenie procesu rehabilitacji.",
                    "Anna Nowak", 
                    LocalDateTime.now(), 
                    LocalDateTime.now(), 
                    LocalDateTime.of(2025, 2, 7, 10, 0), 
                    Arrays.asList("korzyści", "rehabilitacja", "fizjoterapia"), 
                    "opublikowany"
            ));
            blogPostRepository.save(new BlogPost(
                    "Jak dbać o zdrowie kręgosłupa?", 
                    "Zadbaj o zdrowie swojego kręgosłupa poprzez regularne ćwiczenia, unikanie długotrwałego siedzenia i stosowanie odpowiednich postaw ciała.",
                    "Piotr Zieliński", 
                    LocalDateTime.now(), 
                    LocalDateTime.now(), 
                    LocalDateTime.of(2025, 2, 8, 11, 30), 
                    Arrays.asList("kręgosłup", "zdrowie", "ćwiczenia"), 
                    "roboczy"
            ));
        }

        // Dodanie domyślnych danych do tabeli services
        if (serviceRepository.count() == 0) {
            serviceRepository.save(new Services(
                    "Fizjoterapia",
                    "Sesje terapeutyczne pomagające w rehabilitacji mięśni i stawów.",
                    150.00,
                    "aktywny"
            ));
            serviceRepository.save(new Services(
                    "Masaż",
                    "Relaksacyjne sesje masażu pomagające złagodzić stres i napięcie mięśniowe.",
                    120.00,
                    "aktywny"
            ));
            serviceRepository.save(new Services(
                    "Chiropraktyka",
                    "Chiropraktyka pomagająca w poprawie postawy ciała i leczeniu bólów pleców.",
                    180.00,
                    "wstrzymany"
            ));
        }
    }
}
