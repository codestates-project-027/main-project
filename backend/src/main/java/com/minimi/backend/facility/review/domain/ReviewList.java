package com.minimi.backend.facility.review.domain;

import javax.persistence.OneToMany;

public class ReviewList {
    private Long reviewListId;

    private Long facilityId;

    @OneToMany
    private Review review;
}
