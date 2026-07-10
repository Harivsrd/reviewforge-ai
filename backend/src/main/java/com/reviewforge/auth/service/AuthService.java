package com.reviewforge.auth.service;

import com.reviewforge.auth.dto.request.LoginRequest;
import com.reviewforge.auth.dto.response.AuthResponse;

public interface AuthService {
    
    AuthResponse login(LoginRequest request);

}
