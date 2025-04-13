package com.example.rhealth_hms.services.impl;

import com.example.rhealth_hms.data.models.Patient;
import com.example.rhealth_hms.data.repositories.PatientRepository;
import com.example.rhealth_hms.dtos.PatientDTO;
import com.example.rhealth_hms.dtos.requests.CreatePatientRequest;
import com.example.rhealth_hms.mappers.PatientMapper;
import com.example.rhealth_hms.services.PatientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;
    private final ModelMapper modelMapper;
    private final PatientMapper patientMapper;

    @Override
    public PatientDTO createPatient(CreatePatientRequest request) {
        Patient patient = patientMapper.toEntity(request);
        return patientMapper.toDTO(repository.save(patient));
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patientList = repository.findAll();
        return patientList.stream()
                .map(patient -> patientMapper.toDTO(patient))
                .toList();
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        Patient patient = repository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found!"));
        return patientMapper.toDTO(patient);
    }
}
