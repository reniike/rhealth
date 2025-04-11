package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
