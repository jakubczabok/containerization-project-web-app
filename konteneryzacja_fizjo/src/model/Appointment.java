package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private LocalDateTime appointmentTime;

    private String serviceName; 

    private String physiotherapistName; 

    private String status; 
    public Appointment() {}
    public Appointment(String email, LocalDateTime appointmentTime, String serviceName, String physiotherapistName, String status) {
        this.email = email;
        this.appointmentTime = appointmentTime;
        this.serviceName = serviceName;
        this.physiotherapistName = physiotherapistName;
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getPhysiotherapistName() {
        return physiotherapistName;
    }

    public void setPhysiotherapistName(String physiotherapistName) {
        this.physiotherapistName = physiotherapistName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}