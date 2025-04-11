package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<Session, Long> {
}
