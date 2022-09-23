package com.minimi.backend.facility.review.service;

import com.minimi.backend.facility.review.domain.Review;
import com.minimi.backend.facility.review.domain.ReviewDto;
import org.springframework.data.domain.Slice;

public interface ReviewService {
    Slice<ReviewDto.response> getReviewPage(Long facilityId, int page);
}
