package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    boolean existsByPatientId(String patientId);

    Optional<Patient> findByPatientId(String patientId);
}
