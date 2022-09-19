package com.minimi.backend.community.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
    @Getter
    @AllArgsConstructor
    public static class comment {
        private Long commentId;
        private Long contentsId;
        private String contents;
        private String username;
        private LocalDateTime createdAt;
    }

    @Getter
    @AllArgsConstructor
    public static class request{
        private Long contentsId;
        private String username;
        private String userProfile;
        private String contents;
    }


    @Getter
    @AllArgsConstructor
    public static class response{
        private Long commentId;
        private String username;
        private String userProfile;
        private String contents;
        private LocalDateTime createdAt;
    }
    @Getter
    @AllArgsConstructor
    public static class patch{
        private String contents;
    }
}
