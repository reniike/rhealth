package com.example.rhealth_hms.controller;

import com.example.rhealth_hms.dtos.PatientDTO;
import com.example.rhealth_hms.dtos.requests.CreatePatientRequest;
import com.example.rhealth_hms.dtos.requests.UpdatePatientRequest;
import com.example.rhealth_hms.services.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    @PreAuthorize("hasRole('RECEPTIONIST') or hasRole('ADMIN')")
    public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody CreatePatientRequest request){
        return ResponseEntity.ok(patientService.createPatient(request));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('RECEPTIONIST', 'DOCTOR', 'ADMIN')")
    @Operation(summary = "get all patients")
    public ResponseEntity<List<PatientDTO>> getAllPatients(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping(path = "/{patientId}")
    @PreAuthorize("hasAnyRole('RECEPTIONIST', 'DOCTOR', 'ADMIN')")
    @Operation(summary = "Get patient by patientId")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable String patientId){
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }

    @PutMapping(path = "/{patientId}")
    @PreAuthorize("hasAnyRole('RECEPTIONIST', 'ADMIN')")
    @Operation(summary = "Update patient details")
    public ResponseEntity<PatientDTO> updatePatientDetails(@PathVariable String patientId, @Valid @RequestBody UpdatePatientRequest request){
        return ResponseEntity.ok(patientService.updatePatientDetails(patientId, request));
    }

}
