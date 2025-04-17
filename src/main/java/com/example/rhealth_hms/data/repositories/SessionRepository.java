package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Session;
import com.example.rhealth_hms.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Optional<Session> getSessionById(Long id);

    Optional<List<Session>> getSessionsByStaff(User staff);

    Optional<List<Session>> getSessionsByPatient_PatientId(String patientPatientId);
}
