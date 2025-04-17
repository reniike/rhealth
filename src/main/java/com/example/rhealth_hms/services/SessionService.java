package com.example.rhealth_hms.services;

import com.example.rhealth_hms.dtos.SessionDTO;
import com.example.rhealth_hms.dtos.requests.EndSessionRequest;
import com.example.rhealth_hms.dtos.requests.StartSessionRequest;

import java.util.List;

public interface SessionService {

    SessionDTO startSession(StartSessionRequest request);

    SessionDTO endSession(EndSessionRequest request);

    SessionDTO getSession(Long id);

    List<SessionDTO> getSessionsForCurrentDoctor();

    List<SessionDTO> getSessionsForPatient(String patientId);
}
