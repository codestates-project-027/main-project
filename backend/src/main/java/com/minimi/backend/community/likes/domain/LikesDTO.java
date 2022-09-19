package com.minimi.backend.community.likes.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LikesDTO {
    private Long contentsId;
    private String username;
    private Boolean likes;
    @AllArgsConstructor
    @Getter
    public static class request {

        private Long contentsId;
        private String username;
        private Boolean likes;

    }
}
