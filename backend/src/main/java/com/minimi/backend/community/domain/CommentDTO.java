package com.minimi.backend.community.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class CommentDTO {
    @Getter
    @AllArgsConstructor
    public static class comment {
        private Long commentId;
        private Long contentId;
        private String content;
        private String username;
        private LocalDateTime createdAt;
    }
}
