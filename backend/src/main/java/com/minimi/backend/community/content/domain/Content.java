package com.minimi.backend.community.content.domain;

import com.minimi.backend.community.comment.domain.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Content {
    private Long contentId;
    private String title;
    private String content;
    private String username;
    private String userProfile;
    private String createAt;
    private int views;
    private int like;
    private List<CommentDTO.comment> comment;
}
