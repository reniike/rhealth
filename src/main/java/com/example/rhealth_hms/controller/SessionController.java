package com.example.rhealth_hms.controller;

import com.example.rhealth_hms.dtos.SessionDTO;
import com.example.rhealth_hms.dtos.requests.EndSessionRequest;
import com.example.rhealth_hms.dtos.requests.StartSessionRequest;
import com.example.rhealth_hms.services.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @PostMapping
    @Operation(summary = "start session")
    public ResponseEntity<SessionDTO> startSession(@Valid @RequestBody StartSessionRequest request){
        return ResponseEntity.ok(sessionService.startSession(request));
    }

    @PatchMapping
    @Operation(summary = "end session")
    public ResponseEntity<SessionDTO> endSession(@Valid @RequestBody EndSessionRequest request){
        return ResponseEntity.ok(sessionService.endSession(request));
    }
}
