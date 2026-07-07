package com.reviewforge.auth.service.impl;

import com.reviewforge.auth.dto.request.LoginRequest;
import com.reviewforge.auth.dto.response.LoginResponse;
import com.reviewforge.auth.exception.InvalidCredentialsException;
import com.reviewforge.auth.service.AuthService;
import com.reviewforge.user.entity.User;
import com.reviewforge.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() ->
                        new InvalidCredentialsException("Invalid email or password"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid email or password");
        }

        return new LoginResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail()
        );
    }
}