package com.reviewforge.github.repository;

import com.reviewforge.github.entity.GitHubAccount;
import com.reviewforge.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GitHubAccountRepository extends JpaRepository<GitHubAccount, UUID> {

    Optional<GitHubAccount> findByUser(User user);

    Optional<GitHubAccount> findByGithubUsername(String githubUsername);

}
