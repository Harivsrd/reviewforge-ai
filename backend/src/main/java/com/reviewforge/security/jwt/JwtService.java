package com.reviewforge.security.jwt;

import com.reviewforge.user.entity.User;

public interface JwtService {

    String generateToken(User user);

    String extractUsername(String token);

    boolean isTokenValid(String token, String username);
}