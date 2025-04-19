package com.example.rhealth_hms.controller;

import com.example.rhealth_hms.dtos.DiagnosisDTO;
import com.example.rhealth_hms.dtos.requests.CreateDiagnosisRequest;
import com.example.rhealth_hms.services.DiagnosisService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/diagnosis")
@RequiredArgsConstructor
public class DiagnosisController {

    private final DiagnosisService service;

    @PostMapping
    @PreAuthorize("hasRole('DOCTOR')")
    @Operation(summary = "create diagnosis")
    public ResponseEntity<DiagnosisDTO> createDiagnosis(@RequestBody @Valid CreateDiagnosisRequest request){
        return ResponseEntity.ok(service.createDiagnosis(request));
    }

    @GetMapping(path = "/session/{id}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN')")
    @Operation(summary = "get diagnosis for a session")
    public ResponseEntity<DiagnosisDTO> getDiagnosis(@PathVariable Long id){
        return ResponseEntity.ok(service.getDiagnosisBySessionId(id));
    }


}
