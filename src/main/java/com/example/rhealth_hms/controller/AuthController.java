package com.example.rhealth_hms.controller;

import com.example.rhealth_hms.dtos.AuthResponse;
import com.example.rhealth_hms.dtos.requests.LoginRequest;
import com.example.rhealth_hms.dtos.requests.RegisterRequest;
import com.example.rhealth_hms.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

    private final AuthenticationService authService;

    @PostMapping
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
}
