package com.example.rhealth_hms.services.impl;

import com.example.rhealth_hms.data.models.User;
import com.example.rhealth_hms.data.models.enums.StaffStatus;
import com.example.rhealth_hms.data.repositories.UserRepository;
import com.example.rhealth_hms.dtos.AuthResponse;
import com.example.rhealth_hms.dtos.requests.LoginRequest;
import com.example.rhealth_hms.dtos.requests.RegisterRequest;
import com.example.rhealth_hms.security.JwtService;
import com.example.rhealth_hms.security.RhealthUserDetails;
import com.example.rhealth_hms.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public AuthResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        UserDetails userDetails = new RhealthUserDetails(user);
        String token = jwtService.generateToken(userDetails);

        return AuthResponse.builder()
                .token(token)
                .expiresIn(jwtService.getJwtExpiration())
                .build();
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmailIgnoreCase(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .department(request.getDepartment())
                .status(StaffStatus.OFFLINE)
                .build();

        userRepository.save(user);

        UserDetails userDetails = new RhealthUserDetails(user);
        String token = jwtService.generateToken(userDetails);

        return AuthResponse.builder()
                .token(token)
                .expiresIn(jwtService.getJwtExpiration())
                .build();
    }
}
