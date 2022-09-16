package com.minimi.backend.facility.domain;

import com.minimi.backend.auth.domain.Auth;

import java.time.LocalDate;

public class Review {
    private Long reviewId;
    private String user;
    private String userProfile;
    private String contents;
    private Long facilityId;
    private LocalDate createdAt;
}
