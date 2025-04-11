package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepo extends JpaRepository<Drug, Long> {
}
