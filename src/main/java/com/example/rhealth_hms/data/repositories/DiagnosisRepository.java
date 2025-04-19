package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Diagnosis;
import com.example.rhealth_hms.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {

    Optional<Diagnosis> getDiagnosisBySession_IdAndStaff(Long sessionId, User staff);

    Optional<Diagnosis> getDiagnosisBySession_Id(Long id);

}
