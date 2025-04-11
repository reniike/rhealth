package com.example.rhealth_hms.services;

import com.example.rhealth_hms.dtos.AuthResponse;
import com.example.rhealth_hms.dtos.requests.LoginRequest;
import com.example.rhealth_hms.dtos.requests.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {

    AuthResponse authenticate(LoginRequest loginRequest);

    String generateToken(UserDetails userDetails);

    UserDetails validateToken(String token);

    AuthResponse register(RegisterRequest request);
}
