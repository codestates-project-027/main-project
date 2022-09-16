package com.minimi.backend.facility.domain;

import com.minimi.backend.auth.domain.Auth;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class BookmarkDto {

    @AllArgsConstructor
    @Getter
    public static class request{
        private String username;
        private Long facilityId;
    }
}
