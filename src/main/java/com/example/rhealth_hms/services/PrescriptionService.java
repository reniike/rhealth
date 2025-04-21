package com.example.rhealth_hms.services;

import com.example.rhealth_hms.dtos.PrescriptionDTO;
import com.example.rhealth_hms.dtos.requests.PrescriptionRequest;
import jakarta.validation.Valid;

public interface PrescriptionService {

    PrescriptionDTO createPrescription(PrescriptionRequest request);

}
