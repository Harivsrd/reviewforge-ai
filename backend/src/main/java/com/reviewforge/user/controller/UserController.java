package com.reviewforge.user.controller;

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