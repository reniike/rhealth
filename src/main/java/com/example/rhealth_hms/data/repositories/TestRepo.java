package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test, Long> {
}
