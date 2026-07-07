package com.reviewforge.auth.service;

import com.reviewforge.auth.dto.request.LoginRequest;
import com.reviewforge.auth.dto.response.LoginResponse;

public interface AuthService {
    
    LoginResponse login(LoginRequest request);

}
