package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepo extends JpaRepository<Queue, Long> {
}
