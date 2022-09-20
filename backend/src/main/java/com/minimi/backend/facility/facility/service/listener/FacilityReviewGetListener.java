package com.minimi.backend.facility.facility.service.listener;

import com.minimi.backend.facility.review.ReviewDto;
import org.springframework.data.domain.Slice;

public interface FacilityReviewGetListener {
    Slice<ReviewDto.response> getReview(Long facilityId, int page);
}
