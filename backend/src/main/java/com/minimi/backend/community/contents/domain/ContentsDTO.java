package com.minimi.backend.community.contents.domain;

import com.minimi.backend.community.comment.domain.CommentDTO;
import lombok.*;

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

    @Builder
    public ContentsDTO(Long contentsId, String title, String contents, String username){
        this.contentsId=contentsId;
        this.title=title;
        this.contents=contents;
        this.username=username;
        this.views=0;
        this.likes=0;
    }

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
    public static class get {
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
