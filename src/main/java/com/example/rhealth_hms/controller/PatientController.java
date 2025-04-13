package com.example.rhealth_hms.controller;

import com.example.rhealth_hms.dtos.PatientDTO;
import com.example.rhealth_hms.dtos.requests.CreatePatientRequest;
import com.example.rhealth_hms.services.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/vi/patient")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody CreatePatientRequest request){
        return ResponseEntity.ok(patientService.createPatient(request));
    }
}
