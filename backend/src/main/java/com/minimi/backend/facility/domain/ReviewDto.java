package com.minimi.backend.facility.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

public class ReviewDto {

    @AllArgsConstructor
    @Getter
    public static class response{
        private Long reviewId;
        private String user;
        private String userProfile;
        private String contents;
        private LocalDate createdAt;
    }
}
