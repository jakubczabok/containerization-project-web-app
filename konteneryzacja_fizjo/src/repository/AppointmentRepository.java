package com.example.demo.repository;

import com.example.demo.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Wyszukiwanie po e-mailu
    Appointment findByEmail(String email);

    // Wyszukiwanie po dacie i godzinie wizyty
    List<Appointment> findByAppointmentTime(LocalDateTime appointmentTime);

    // Wyszukiwanie wszystkich wizyt w danym okresie
    List<Appointment> findByAppointmentTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    // Wyszukiwanie wizyt z określoną usługą (np. rehabilitacja, masaż)
    List<Appointment> findByServiceName(String serviceName);

    // Wyszukiwanie wizyt przypisanych do konkretnego fizjoterapeuty (jeśli masz taką właściwość w modelu Appointment)
    List<Appointment> findByPhysiotherapistName(String physiotherapistName);

    // Wyszukiwanie wizyt z określoną usługą i w określonym czasie
    List<Appointment> findByServiceNameAndAppointmentTimeBetween(String serviceName, LocalDateTime startDateTime, LocalDateTime endDateTime);

    // Wyszukiwanie po statusie wizyty (np. "oczekująca", "potwierdzona", "odwołana") - jeśli masz taki status
    List<Appointment> findByStatus(String status);

    // Wyszukiwanie wizyt w przyszłości (wszystkie wizyty, które są zaplanowane po teraz)
    List<Appointment> findByAppointmentTimeAfter(LocalDateTime now);
}
