package com.example.rhealth_hms.services.impl;

import com.example.rhealth_hms.data.models.Diagnosis;
import com.example.rhealth_hms.data.models.Session;
import com.example.rhealth_hms.data.models.User;
import com.example.rhealth_hms.data.models.enums.SessionStatus;
import com.example.rhealth_hms.data.repositories.DiagnosisRepository;
import com.example.rhealth_hms.dtos.DiagnosisDTO;
import com.example.rhealth_hms.dtos.requests.CreateDiagnosisRequest;
import com.example.rhealth_hms.exceptions.RhealthException;
import com.example.rhealth_hms.services.DiagnosisService;
import com.example.rhealth_hms.services.SessionService;
import com.example.rhealth_hms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosisRepository repository;
    private final ModelMapper mapper;
    private final UserService userService;
    private final SessionService sessionService;

    @Override
    public DiagnosisDTO createDiagnosis(CreateDiagnosisRequest request) {
        User user = userService.getCurrentUser();
        Session session = sessionService.getSessionById(request.getSessionId());

        if (session.getStatus() == SessionStatus.COMPLETED) {
            throw new RhealthException("You can't diagnose a completed session.");
        }

        Diagnosis diagnosis = Diagnosis.builder()
                .staff(user)
                .session(session)
                .patient(session.getPatient())
                .title(request.getTitle())
                .note(request.getNote())
                .build();

        repository.save(diagnosis);
        return mapper.map(diagnosis, DiagnosisDTO.class);
    }
}
