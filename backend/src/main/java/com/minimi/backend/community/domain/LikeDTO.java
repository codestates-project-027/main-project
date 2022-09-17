package com.minimi.backend.community.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LikeDTO {
    private Long contentId;
    private String username;
    private Boolean like;
    @AllArgsConstructor
    @Getter
    public static class request {

        private Long contentId;
        private String username;
        private Boolean like;

    }
}
