package com.reviewforge.github.service.impl;

import org.springframework.stereotype.Service;

import com.reviewforge.github.client.GitHubApiClient;
import com.reviewforge.github.dto.response.GitHubProfileResponse;
import com.reviewforge.github.service.GitHubService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GitHubServiceImpl implements GitHubService {

    private final GitHubApiClient gitHubApiClient;

    @Override
    public GitHubProfileResponse getProfile(String accessToken) {
        return gitHubApiClient.getProfile(accessToken);
    }
}