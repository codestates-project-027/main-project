package com.minimi.backend.community.domain;

import java.time.LocalDateTime;

public class Comment {
    private Long commentId;
    private Long contentId;
    private String content;
    private String username;
    private LocalDateTime createdAt;

}
