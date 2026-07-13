package com.reviewforge.github.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.reviewforge.github.dto.response.GitHubProfileResponse;

@Component
public class GitHubApiClient {

    private final WebClient webClient;

    public GitHubApiClient(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://api.github.com")
                .build();
    }

    public GitHubProfileResponse getProfile(String accessToken) {

        return webClient.get()
                    .uri("/user")
                    .headers(headers -> headers.setBearerAuth(accessToken))
                    .retrieve()
                    .bodyToMono(GitHubProfileResponse.class)
                    .block();
    }
}