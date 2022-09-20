package com.minimi.backend.facility.facility.service.facility.listener;

import com.minimi.backend.facility.review.ReviewDto;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface FacilityReviewGetListener {
    List<ReviewDto.response> getReview(Long facilityId);
}
