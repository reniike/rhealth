package com.example.rhealth_hms.services;

import com.example.rhealth_hms.dtos.PatientDTO;
import com.example.rhealth_hms.dtos.requests.CreatePatientRequest;

import java.util.List;

public interface PatientService {

    PatientDTO createPatient(CreatePatientRequest request);

    List<PatientDTO> getAllPatients();

    PatientDTO getPatientById(Long id);
}
