package com.reviewforge.user.dto.response;

import java.util.UUID;

public record RegisterResponse (
    
    UUID id, 

    String fullname,

    String email
) {}