package com.example.rhealth_hms.controller;

import com.example.rhealth_hms.dtos.DiagnosisDTO;
import com.example.rhealth_hms.dtos.requests.CreateDiagnosisRequest;
import com.example.rhealth_hms.services.DiagnosisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/diagnosis")
@RequiredArgsConstructor
public class DiagnosisController {

    private final DiagnosisService service;

    @PostMapping
    public ResponseEntity<DiagnosisDTO> createDiagnosis(@RequestBody @Valid CreateDiagnosisRequest request){
        return ResponseEntity.ok(service.createDiagnosis(request));
    }


}
