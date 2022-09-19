package com.minimi.backend.community.likes.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Likes {
    private Long likesId;
    private String username;
    private Boolean likes;
}
