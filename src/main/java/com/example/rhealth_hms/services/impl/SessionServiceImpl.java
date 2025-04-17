package com.example.rhealth_hms.services.impl;

import com.example.rhealth_hms.data.models.Patient;
import com.example.rhealth_hms.data.models.Session;
import com.example.rhealth_hms.data.models.User;
import com.example.rhealth_hms.data.models.enums.SessionStatus;
import com.example.rhealth_hms.data.repositories.SessionRepository;
import com.example.rhealth_hms.dtos.SessionDTO;
import com.example.rhealth_hms.dtos.requests.EndSessionRequest;
import com.example.rhealth_hms.dtos.requests.StartSessionRequest;
import com.example.rhealth_hms.exceptions.RhealthException;
import com.example.rhealth_hms.services.PatientService;
import com.example.rhealth_hms.services.SessionService;
import com.example.rhealth_hms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.example.rhealth_hms.utils.AppUtils.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository repository;
    private final UserService userService;
    private final PatientService patientService;
    private final ModelMapper mapper;


    @Override
    public SessionDTO startSession(StartSessionRequest request) {
        User user = userService.getLoggedInUser();
        Patient patient = patientService.getPatient(request.getPatientId());

        Session session = Session.builder()
                .staff(user)
                .patient(patient)
                .status(SessionStatus.ONGOING)
                .startedAt(LocalDate.now())
                .build();

        repository.save(session);

        return mapper.map(session, SessionDTO.class);
    }

    @Override
    public SessionDTO endSession(EndSessionRequest request) {

        Session session = repository.getSessionById(request.getSessionId()).orElseThrow(() -> new RhealthException(NOT_FOUND));

        User currentUser = userService.getLoggedInUser();
        if (!session.getStaff().getId().equals(currentUser.getId())) {
            throw new RhealthException("You’re not allowed to end this session");
        }

        session.setStatus(SessionStatus.COMPLETED);
        session.setEndedAt(LocalDate.now());

        repository.save(session);
        return mapper.map(session, SessionDTO.class);
    }
}
