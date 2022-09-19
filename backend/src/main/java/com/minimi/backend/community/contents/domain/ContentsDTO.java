package com.minimi.backend.community.contents.domain;

import com.minimi.backend.community.comment.domain.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ContentsDTO {
    private Long contentsId;
    private String title;
    private String contents;
    private String username;
    private LocalDateTime createdAt;
    private String userProfile;
    private int views;
    private int likes;
    private List<CommentDTO.comment> comment;

    @AllArgsConstructor
    @Getter
    public static class request {

        private String title;
        private String contents;
        private String username;

    }
    @Getter
    @AllArgsConstructor
    public static class response {
        private Long contentsId;
        private String title;
        private String contents;
        private String username;
        private LocalDateTime createdAt;
        private String userProfile;
        private int views;
        private int likes;
        private List<CommentDTO.comment> comment;

    }
    @Getter
    @AllArgsConstructor
    public static class contents {
        private Long contentsId;
        private String title;
        private String username;
        private LocalDateTime createdAt;
        private int views;
        private int likes;
    }
    @AllArgsConstructor
    @Getter
    public static class patch {

        private String title;
        private String contents;

    }

}
