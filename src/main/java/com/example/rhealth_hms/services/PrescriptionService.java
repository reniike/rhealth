package com.example.rhealth_hms.services;

import com.example.rhealth_hms.dtos.PrescriptionDTO;
import com.example.rhealth_hms.dtos.requests.PrescriptionRequest;

import java.util.List;

public interface PrescriptionService {

    PrescriptionDTO createPrescription(PrescriptionRequest request);

    PrescriptionDTO getPrescriptionBySessionId(Long sessionId);

    List<PrescriptionDTO> getPrescriptionsByPatientId(Long patientId);
}
