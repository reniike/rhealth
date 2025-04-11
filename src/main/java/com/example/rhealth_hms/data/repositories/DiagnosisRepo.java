package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepo extends JpaRepository<Diagnosis, Long> {
}
