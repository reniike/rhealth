package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.TestRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRequestRepo extends JpaRepository<TestRequest, Long> {
}
