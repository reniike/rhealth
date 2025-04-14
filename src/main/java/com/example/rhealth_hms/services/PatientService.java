package com.example.rhealth_hms.services;

import com.example.rhealth_hms.data.models.Patient;
import com.example.rhealth_hms.dtos.PatientDTO;
import com.example.rhealth_hms.dtos.requests.CreatePatientRequest;
import com.example.rhealth_hms.dtos.requests.UpdatePatientRequest;

import java.util.List;

public interface PatientService {

    PatientDTO createPatient(CreatePatientRequest request);

    List<PatientDTO> getAllPatients();

    PatientDTO getPatientById(String patientId);

    Patient getPatient(String patientId);

    PatientDTO updatePatientDetails(String patientId, UpdatePatientRequest request);
}
