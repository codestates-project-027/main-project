package com.minimi.backend.facility.review;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

public class ReviewDto {

    @AllArgsConstructor
    @Getter
    public static class response{
        private Long reviewId;
        private String username;
        private String userProfile;
        private String contents;
        private LocalDate createdAt;
    }

    @AllArgsConstructor
    @Getter
    public static class request{
        private Long facilityId;
        private String username;
        private String contents;
    }

    @AllArgsConstructor
    @Getter
    public static class patch{
        private String username;
        private String contents;
    }
}
