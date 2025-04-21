package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.PrescriptionItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionItemRepository extends JpaRepository<PrescriptionItem, Long> {
}
