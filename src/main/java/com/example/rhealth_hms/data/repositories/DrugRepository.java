package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DrugRepository extends JpaRepository<Drug, Long> {
    Optional<Drug> getDrugById(Long id);
}
