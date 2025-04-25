package com.example.rhealth_hms.services.impl;

import com.example.rhealth_hms.data.models.Patient;
import com.example.rhealth_hms.data.models.User;
import com.example.rhealth_hms.data.models.enums.Department;
import com.example.rhealth_hms.data.repositories.PatientRepository;
import com.example.rhealth_hms.dtos.PatientDTO;
import com.example.rhealth_hms.dtos.requests.CreatePatientRequest;
import com.example.rhealth_hms.dtos.requests.UpdatePatientRequest;
import com.example.rhealth_hms.exceptions.RhealthException;
import com.example.rhealth_hms.mappers.PatientMapper;
import com.example.rhealth_hms.services.PatientService;
import com.example.rhealth_hms.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static com.example.rhealth_hms.utils.AppUtils.NOT_FOUND;
import static com.example.rhealth_hms.utils.AppUtils.UNAUTHORIZED;

@Service
@AllArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;
    private final PatientMapper patientMapper;
    private final UserService userService;

    @Override
    public PatientDTO createPatient(CreatePatientRequest request) {
        User user = userService.getCurrentUser();
        if (!List.of(Department.ADMIN, Department.RECEPTIONIST).contains(user.getDepartment())) {
            throw new RhealthException(UNAUTHORIZED);
        }

        Patient patient = patientMapper.toEntity(request);
        patient.setPatientId(generateUniquePatientId());

        return patientMapper.toDTO(repository.save(patient));
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patientList = repository.findAll();
        return patientList.stream()
                .map(patientMapper::toDTO)
                .toList();
    }

    @Override
    public PatientDTO getPatientById(String patientId) {
        Patient patient = repository.findByPatientId(patientId).orElseThrow(() -> new RhealthException(NOT_FOUND));
        return patientMapper.toDTO(patient);
    }

    @Override
    public Patient getPatient(Long patientId) {
        return repository.findById(patientId).orElseThrow(() -> new RhealthException(NOT_FOUND));
    }

    @Override
    public PatientDTO updatePatientDetails(String patientId, UpdatePatientRequest request) {
        User user = userService.getCurrentUser();
        if (!List.of(Department.ADMIN, Department.RECEPTIONIST).contains(user.getDepartment())) {
            throw new RhealthException(UNAUTHORIZED);
        }

        Patient patient = repository.findByPatientId(patientId).orElseThrow(() -> new RhealthException(NOT_FOUND));
        return patientMapper.toDTO(repository.save(patient));
    }

    // Output sample: P24-5832
    public String generatePatientId() {
            String year = String.valueOf(LocalDate.now().getYear()).substring(2);
            int random = new Random().nextInt(9000) + 1000;
            return "P" + year + "-" + random;
    }

    private String generateUniquePatientId(){
        String patientId;
        do {
            patientId = generatePatientId();
        } while (repository.existsByPatientId(patientId));
        return patientId;
    }

}
