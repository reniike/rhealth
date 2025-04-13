package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.TestRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRequestRepository extends JpaRepository<TestRequest, Long> {
}
