package com.reviewforge.user.service;

import com.reviewforge.user.dto.request.RegisterRequest;
import com.reviewforge.user.dto.response.RegisterResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest request);

}