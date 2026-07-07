package com.reviewforge.user.controller;

import com.reviewforge.common.response.ApiResponse;
import com.reviewforge.user.dto.request.RegisterRequest;
import com.reviewforge.user.dto.response.RegisterResponse;
import com.reviewforge.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ApiResponse<RegisterResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        RegisterResponse response = userService.register(request);

        return ApiResponse.<RegisterResponse>builder()
                .success(true)
                .message("User registered successfully")
                .data(response)
                .timestamp(LocalDateTime.now())
                .build();
    }
}