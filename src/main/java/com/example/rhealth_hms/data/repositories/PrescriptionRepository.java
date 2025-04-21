package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    Optional<Prescription> getPrescriptionsBySession_Id(Long sessionId);

}
