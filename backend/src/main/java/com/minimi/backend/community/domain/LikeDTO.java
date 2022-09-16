package com.minimi.backend.community.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LikeDTO {
    private Long likeId;
    private String username;
    private Boolean content;
}
