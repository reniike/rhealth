package com.example.rhealth_hms.services;

import com.example.rhealth_hms.dtos.SessionDTO;
import com.example.rhealth_hms.dtos.requests.EndSessionRequest;
import com.example.rhealth_hms.dtos.requests.StartSessionRequest;

public interface SessionService {

    SessionDTO startSession(StartSessionRequest request);

    SessionDTO endSession(EndSessionRequest request);
}
