package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

}
