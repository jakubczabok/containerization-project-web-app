package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String status;
    public Services() {}

    public Services(String name, String description, Double price, String status) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
    }

        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }

        public String getName(){
            return name;
        }
    
    
        public void setName(String name){
            this.name=name;
        }

        
        public String getStatus(){
            return status;
        }

        public void setStatus(String status){
            this.status=status;
        }

        public String getDescription(){
            return description;
        }

        public void setDescription(String description){
            this.description=description;;
        }

        public double getPrice(){
            return price;
        }

        public void setPrice(Double price){
            this.price=price;
        }
   
        }

