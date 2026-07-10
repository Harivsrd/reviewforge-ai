package com.reviewforge.auth.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.reviewforge.auth.dto.request.LoginRequest;
import com.reviewforge.auth.dto.response.AuthResponse;
import com.reviewforge.auth.exception.InvalidCredentialsException;
import com.reviewforge.auth.service.AuthService;
import com.reviewforge.security.jwt.JwtService;
import com.reviewforge.user.entity.User;
import com.reviewforge.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() ->
                        new InvalidCredentialsException("Invalid email or password"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid email or password");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponse(
                token,
                "Bearer",
                86400
        );
    }
}