package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
