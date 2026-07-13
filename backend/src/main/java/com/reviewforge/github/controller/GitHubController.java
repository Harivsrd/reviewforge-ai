package com.reviewforge.github.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewforge.github.dto.response.GitHubProfileResponse;
import com.reviewforge.github.service.GitHubService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/github")
@RequiredArgsConstructor
public class GitHubController {

    private final GitHubService gitHubService;

    @GetMapping("/profile")
    public GitHubProfileResponse getProfile(
            @RequestHeader(value = "Authorization", required = false)
            String authorization) {

        System.out.println("Authorization Header = " + authorization);

        if (authorization == null) {
            throw new RuntimeException("Authorization header is missing!");
        }

        String token = authorization.replace("Bearer ", "");

        return gitHubService.getProfile(token);
}

}