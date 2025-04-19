package com.example.rhealth_hms.services.impl;

import com.example.rhealth_hms.data.models.Diagnosis;
import com.example.rhealth_hms.data.models.Session;
import com.example.rhealth_hms.data.models.User;
import com.example.rhealth_hms.data.models.enums.Department;
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

import java.util.List;

import static com.example.rhealth_hms.utils.AppUtils.NOT_FOUND;

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

    @Override
    public DiagnosisDTO getDiagnosisBySessionId(Long id) {
        User user = userService.getCurrentUser();

        Diagnosis diagnosis = user.getDepartment().equals(Department.ADMIN)
                        ? repository.getDiagnosisBySession_Id(id)
                        .orElseThrow(() -> new RhealthException(NOT_FOUND))
                        : repository.getDiagnosisBySession_IdAndStaff(id, user)
                        .orElseThrow(() -> new RhealthException(NOT_FOUND));


        return mapper.map(diagnosis, DiagnosisDTO.class);
    }

    @Override
    public List<DiagnosisDTO> getDiagnosesByPatientId(Long id) {
        User user = userService.getCurrentUser();

        List<Diagnosis> diagnoses = user.getDepartment().equals(Department.ADMIN)
                ? repository.findAllByPatient_Id(id)
                : repository.findAllByPatient_IdAndStaff(id, user);

        return diagnoses.stream()
                .map(diagnosis -> mapper.map(diagnosis, DiagnosisDTO.class))
                .toList();
    }

}
