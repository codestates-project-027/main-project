package com.minimi.backend.community.domain;

import java.util.List;

public class Post {
    private Long postId;
    private String title;
    private String contents;
    private String username;
    private String userProfile;
    private String createAt;
    private int views;
    private int like;
    private List<Comment> comment;
}
