package com.minimi.backend.community.domain;

import java.time.LocalDateTime;

public class Comment {
    private Long commentId;
    private Long postId;
    private String contents;
    private String username;
    private LocalDateTime createdAt;

}
