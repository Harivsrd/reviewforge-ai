package com.reviewforge.auth.dto.response;

import java.util.UUID;

public record LoginResponse(

        UUID id,
        String fullName,
        String email

) {}