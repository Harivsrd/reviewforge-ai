package com.reviewforge.github.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GitHubProfileResponse(

        @JsonProperty("login")
        String username,

        @JsonProperty("name")
        String displayName,

        @JsonProperty("avatar_url")
        String avatarUrl

) {
}