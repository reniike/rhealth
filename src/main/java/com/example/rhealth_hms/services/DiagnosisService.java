package com.example.rhealth_hms.services;

import com.example.rhealth_hms.dtos.DiagnosisDTO;
import com.example.rhealth_hms.dtos.requests.CreateDiagnosisRequest;

import java.util.List;

public interface DiagnosisService {

    DiagnosisDTO createDiagnosis(CreateDiagnosisRequest request);

    DiagnosisDTO getDiagnosisBySessionId(Long id);

    List<DiagnosisDTO> getDiagnosesByPatientId(Long id);
}
