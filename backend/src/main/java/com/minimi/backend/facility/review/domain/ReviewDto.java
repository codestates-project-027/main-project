package com.minimi.backend.facility.review.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReviewDto {

    @AllArgsConstructor
    @Getter
    @Builder
    public static class response{
        private Long reviewId;
        private String username;
        private String contents;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
        private LocalDateTime createdAt;
    }

    @AllArgsConstructor
    @Getter
    @Builder
    public static class request{
        private Long facilityId;
        private String username;
        private String contents;
    }

    @AllArgsConstructor
    @Getter
    @Builder
    public static class patch{
        private String username;
        private String contents;
    }
}
