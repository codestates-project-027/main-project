package com.minimi.backend.community.likes.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikesDTO {
    private Long contentsId;
    private String username;

}
