package com.example.rhealth_hms.services.impl;

import com.example.rhealth_hms.data.models.User;
import com.example.rhealth_hms.data.models.enums.StaffStatus;
import com.example.rhealth_hms.data.repositories.UserRepository;
import com.example.rhealth_hms.dtos.AuthResponse;
import com.example.rhealth_hms.dtos.requests.LoginRequest;
import com.example.rhealth_hms.dtos.requests.RegisterRequest;
import com.example.rhealth_hms.services.AuthenticationService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final Long jwtExpiration = 86400000L;
    @Value("${jwt.secret}")
    private String secretKey;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public AuthResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        String token = generateToken(userDetailsService.loadUserByUsername(request.getEmail()));

        return AuthResponse.builder()
                .token(token)
                .expiresIn(jwtExpiration)
                .build();
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public UserDetails validateToken(String token) {
        String username = extractUsername(token);
        return userDetailsService.loadUserByUsername(username);
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmailIgnoreCase(request.getEmail())) throw new IllegalArgumentException("Email already exists");

        log.info("1");
        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .department(request.getDepartment())
                .status(StaffStatus.OFFLINE
                )
                .build();

        log.info("2");

        userRepository.save(user);

        log.info("Saved user: {}", user.getFirstName());
        log.info("User id: {}", user.getId());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = generateToken(userDetails);

        return AuthResponse.builder()
                .token(token)
                .expiresIn(jwtExpiration)
                .build();
    }

    private String extractUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    private Key getSigningKey() {
        byte[] keyBytes = secretKey.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
