package com.minimi.backend.community.comment.domain;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {

    private String content;
    private String username;
    private Long contentsId;

    @Builder
    public CommentDTO(String content,String username, Long contentsId){
        this.content=content;
        this.username=username;
        this.contentsId=contentsId;
    }

    public CommentDTO(String content) {
        this.content=content;
    }

    @Getter
    @AllArgsConstructor
    public static class comment {
        private Long commentId;
        private Long contentsId;
        private String content;
        private String username;
        private LocalDateTime createdAt;
    }

    @Getter
    @AllArgsConstructor
    public static class request{
        private Long contentsId;
        private String username;
        private String userProfile;
        private String content;
    }


    @Getter
    @AllArgsConstructor
    public static class response{
        private Long commentId;
        private String username;
        private String userProfile;
        private String content;
        private LocalDateTime createdAt;
    }
    //@Getter
    //@AllArgsConstructor
//    public static class patch{
//        private String content;
//
//        public String getContent(){
//            return content;
//        }
//        public patch(String content){
//            this.content=content;
//        }
//    }
}
