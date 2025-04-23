package com.example.rhealth_hms.controller;

import com.example.rhealth_hms.dtos.PrescriptionDTO;
import com.example.rhealth_hms.dtos.requests.PrescriptionRequest;
import com.example.rhealth_hms.services.PrescriptionService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prescriptions")
@RequiredArgsConstructor
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @PostMapping
    @PreAuthorize("hasRole('DOCTOR')")
    @Operation(summary = "create prescription")
    public ResponseEntity<PrescriptionDTO> create(@Valid @RequestBody PrescriptionRequest request) {
        return ResponseEntity.ok(prescriptionService.createPrescription(request));
    }

    @GetMapping(path = "/session/{sessionId}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'PHARMACIST')")
    @Operation(summary = "get prescription by session id")
    public ResponseEntity<PrescriptionDTO> getPrescription(@PathVariable Long sessionId){
        return ResponseEntity.ok(prescriptionService.getPrescriptionBySessionId(sessionId));
    }

    @GetMapping(path = "/patient/{patientId}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'PHARMACIST')")
    @Operation(summary = "get prescription by patient id")
    public ResponseEntity<List<PrescriptionDTO>> getPrescriptions(@PathVariable Long patientId){
        return ResponseEntity.ok(prescriptionService.getPrescriptionsByPatientId(patientId));
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasRole('DOCTOR')")
    @Operation(summary = "delete prescription")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return ResponseEntity.noContent().build();
    }
}

