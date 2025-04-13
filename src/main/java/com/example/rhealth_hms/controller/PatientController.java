package com.example.rhealth_hms.controller;

import com.example.rhealth_hms.dtos.PatientDTO;
import com.example.rhealth_hms.dtos.requests.CreatePatientRequest;
import com.example.rhealth_hms.services.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/vi/patient")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody CreatePatientRequest request){
        return ResponseEntity.ok(patientService.createPatient(request));
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get patient by patientId")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

}
