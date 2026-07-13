package com.reviewforge.github.entity;

import com.reviewforge.common.model.BaseEntity;
import com.reviewforge.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "github_accounts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GitHubAccount extends BaseEntity {

    @Column(name = "github_user_id", nullable = false, unique = true)
    private String githubUserId;

    @Column(name = "github_username", nullable =false, unique = true)
    private String githubUsername;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "access_token", columnDefinition = "TEXT")
    private String accessToken;

    @Column(name = "connected_at")
    private LocalDateTime connectedAt;

    @Builder.Default
    @Column(name = "connected", nullable = false)
    private boolean connected = true;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}