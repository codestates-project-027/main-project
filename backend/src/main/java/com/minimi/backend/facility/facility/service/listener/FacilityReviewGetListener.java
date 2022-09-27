package com.minimi.backend.facility.facility.service.listener;

import com.minimi.backend.facility.review.domain.ReviewDto;

import java.util.List;

public interface FacilityReviewGetListener {
    List<ReviewDto.response> getReview(Long facilityId);
}
