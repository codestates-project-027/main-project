package com.minimi.backend.facility.review.domain;

import com.minimi.backend.auth.domain.Auth;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class Review {
    private Long reviewId;
    private String username;
    private String contents;
    private LocalDate createdAt;

    @ManyToOne
    private ReviewList reviewList;
}