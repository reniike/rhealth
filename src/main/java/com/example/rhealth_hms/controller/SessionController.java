package com.example.rhealth_hms.controller;

import com.example.rhealth_hms.data.models.enums.SessionStatus;
import com.example.rhealth_hms.dtos.SessionDTO;
import com.example.rhealth_hms.dtos.requests.EndSessionRequest;
import com.example.rhealth_hms.dtos.requests.StartSessionRequest;
import com.example.rhealth_hms.services.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @PostMapping
    @PreAuthorize("hasRole('DOCTOR')")
    @Operation(summary = "start session")
    public ResponseEntity<SessionDTO> startSession(@Valid @RequestBody StartSessionRequest request){
        return ResponseEntity.ok(sessionService.startSession(request));
    }

    @PatchMapping
    @PreAuthorize("hasRole('DOCTOR')")
    @Operation(summary = "end session")
    public ResponseEntity<SessionDTO> endSession(@Valid @RequestBody EndSessionRequest request){
        return ResponseEntity.ok(sessionService.endSession(request));
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN')")
    @Operation(summary = "get session by id")
    public ResponseEntity<SessionDTO> getSession(@PathVariable Long id){
        return ResponseEntity.ok(sessionService.getSession(id));
    }

    @GetMapping(path = "/doctorId")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN')")
    @Operation(summary = "Get all sessions for current doctor")
    public ResponseEntity<List<SessionDTO>> getSessionsForCurrentDoctor(){
        return ResponseEntity.ok(sessionService.getSessionsForCurrentDoctor());
    }

    @GetMapping(path = "/patient/{patientId}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN')")
    @Operation(summary = "Get all sessions for single patient")
    public ResponseEntity<List<SessionDTO>> getSessionsForPatient(@PathVariable String patientId) {
        return ResponseEntity.ok(sessionService.getSessionsForPatient(patientId));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN')")
    @Operation(summary = "Get sessions by status")
    public ResponseEntity<List<SessionDTO>> getSessionsByStatus(@RequestParam SessionStatus status) {
        return ResponseEntity.ok(sessionService.getSessionsByStatus(status));
    }


}
