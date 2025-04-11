package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepo extends JpaRepository<Prescription, Long> {
}
