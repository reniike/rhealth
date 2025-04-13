package com.example.rhealth_hms.services;

import com.example.rhealth_hms.dtos.PatientDTO;
import com.example.rhealth_hms.dtos.requests.CreatePatientRequest;

public interface PatientService {

    PatientDTO createPatient(CreatePatientRequest request);

}
