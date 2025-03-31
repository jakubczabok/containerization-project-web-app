package com.example.demo.service;

import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Tworzenie nowej rezerwacji
    public Appointment createAppointment(Appointment appointment) {
        // Można tu dodać dodatkową logikę walidacyjną, np. sprawdzanie dostępności terminu
        return appointmentRepository.save(appointment);
    }

    // Pobieranie wszystkich rezerwacji
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Wyszukiwanie rezerwacji po emailu
    public Appointment getAppointmentByEmail(String email) {
        return appointmentRepository.findByEmail(email);
    }

    // Wyszukiwanie wizyt w przyszłości (wszystkie wizyty, które są zaplanowane po teraz)
    public List<Appointment> getAvailableAppointments(LocalDateTime now) {
        return appointmentRepository.findByAppointmentTimeAfter(now);
    }

    // Wyszukiwanie wizyt po dacie i godzinie
    public List<Appointment> getAppointmentsByAppointmentTime(LocalDateTime appointmentTime) {
        return appointmentRepository.findByAppointmentTime(appointmentTime);
    }

    // Wyszukiwanie wizyt w danym okresie
    public List<Appointment> getAppointmentsBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return appointmentRepository.findByAppointmentTimeBetween(startDateTime, endDateTime);
    }

    // Wyszukiwanie wizyt z określoną usługą
    public List<Appointment> getAppointmentsByServiceName(String serviceName) {
        return appointmentRepository.findByServiceName(serviceName);
    }

    // Wyszukiwanie wizyt przypisanych do konkretnego fizjoterapeuty
    public List<Appointment> getAppointmentsByPhysiotherapistName(String physiotherapistName) {
        return appointmentRepository.findByPhysiotherapistName(physiotherapistName);
    }

    // Wyszukiwanie wizyt z określoną usługą i w określonym czasie
    public List<Appointment> getAppointmentsByServiceNameAndTimeBetween(String serviceName, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return appointmentRepository.findByServiceNameAndAppointmentTimeBetween(serviceName, startDateTime, endDateTime);
    }

    // Wyszukiwanie wizyt po statusie
    public List<Appointment> getAppointmentsByStatus(String status) {
        return appointmentRepository.findByStatus(status);
    }

    // Anulowanie rezerwacji
    public void cancelAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}