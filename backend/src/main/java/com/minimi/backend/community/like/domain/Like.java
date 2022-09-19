package com.minimi.backend.community.like.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Like {
    private Long likeId;
    private String username;
    private Boolean like;
}
