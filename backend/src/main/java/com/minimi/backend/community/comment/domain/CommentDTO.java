package com.minimi.backend.community.comment.domain;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {

    private String contents;
    private String userName;
    private Long contentsId;
    @Builder
    public CommentDTO(String contents,String userName, Long questionId){
        this.contents=contents;
        this.userName=userName;
        this.contentsId=contentsId;
    }
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
