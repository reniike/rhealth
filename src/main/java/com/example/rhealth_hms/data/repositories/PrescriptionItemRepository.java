package com.example.rhealth_hms.data.repositories;

import com.example.rhealth_hms.data.models.Prescription;
import com.example.rhealth_hms.data.models.PrescriptionItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionItemRepository extends JpaRepository<PrescriptionItem, Long> {

    List<PrescriptionItem> findAllByPrescription(Prescription prescription);
}
