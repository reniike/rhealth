package com.example.rhealth_hms.services;

import com.example.rhealth_hms.dtos.DiagnosisDTO;
import com.example.rhealth_hms.dtos.requests.CreateDiagnosisRequest;

public interface DiagnosisService {

    DiagnosisDTO createDiagnosis(CreateDiagnosisRequest request);

}
