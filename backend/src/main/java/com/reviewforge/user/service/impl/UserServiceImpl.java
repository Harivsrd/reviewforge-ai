package com.reviewforge.user.service.impl;

import com.reviewforge.user.entity.User;
import com.reviewforge.common.constants.AuthProvider;
import com.reviewforge.user.dto.request.RegisterRequest;
import com.reviewforge.user.dto.response.RegisterResponse;
import com.reviewforge.user.exception.EmailAlreadyExistsException;
import com.reviewforge.user.repository.UserRepository;
import com.reviewforge.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(
                    "Email already registered");
        }

        User user = User.builder()
                .fullName(request.fullName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .provider(AuthProvider.LOCAL)
                .build();

        User savedUser = userRepository.save(user);

        return new RegisterResponse(
                savedUser.getId(),
                savedUser.getFullName(),
                savedUser.getEmail()
        );
    }
}