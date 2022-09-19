package com.minimi.backend.community.comment.domain;

import java.time.LocalDateTime;

public class Comment {
    private Long commentId;
    private Long contentsId;
    private String contents;
    private String username;
    private LocalDateTime createdAt;

}
