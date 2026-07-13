package com.reviewforge.github.service;

import com.reviewforge.github.dto.response.GitHubProfileResponse;

public interface GitHubService {

    GitHubProfileResponse getProfile(String accessToken);

}