package com.minimi.backend.community.contents.domain;

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
public class Contents {
    private Long contentsId;
    private String title;
    private String contents;
    private String username;
    private String userProfile;
    private String createAt;
    private int views;
    private int likes;
    private List<CommentDTO.comment> comment;
}
