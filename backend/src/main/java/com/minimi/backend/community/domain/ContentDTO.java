package com.minimi.backend.community.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ContentDTO {
    private Long contentId;
    private String title;
    private String content;
    private String username;
    private LocalDateTime createdAt;
    private String userProfile;
    private int views;
    private int like;
    private List<Comment> comment;

    @AllArgsConstructor
    @Getter

    public static class request {

        private String title;
        private String content;
        private String username;

    }
    @Getter
    @AllArgsConstructor
    public static class response {
        private Long id;
        private String title;
        private String content;
        private String username;
        private LocalDateTime createdAt;
        private String userProfile;
        private int views;
        private int like;
        private List<Comment> comment;

    }
    @Getter
    @AllArgsConstructor
    public static class patch{

        private String title;
        private String contents;
        private String username;


    }

}
