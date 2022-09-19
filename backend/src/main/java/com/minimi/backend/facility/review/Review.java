package com.minimi.backend.facility.review;

import com.minimi.backend.auth.domain.Auth;

import java.time.LocalDate;

public class Review {
    private Long reviewId;
    private String username;
    private String userProfile;
    private String contents;
    private Long facilityId;
    private LocalDate createdAt;
}
