package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    Optional<Prescription> getPrescriptionBySession_Id(Long sessionId);

    Optional<Prescription> getPrescriptionsByPatient_Id(Long patientId);

    List<Prescription> findAllByPatient_Id(Long patientId);

}
