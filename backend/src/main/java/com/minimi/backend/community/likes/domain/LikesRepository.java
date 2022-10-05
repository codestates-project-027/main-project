package com.minimi.backend.community.likes.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findLikesByUsernameAndContentsId(String username, Long contentsId);
}
