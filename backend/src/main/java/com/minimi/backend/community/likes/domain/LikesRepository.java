package com.minimi.backend.community.likes.domain;

import com.minimi.backend.auth.domain.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findLikesByAuthAndContentsId(Auth auth, Long contentsId);
}
