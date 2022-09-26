package com.minimi.backend.facility.review.service;

import com.minimi.backend.facility.review.domain.Review;
import com.minimi.backend.facility.review.domain.ReviewDto;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ReviewService {
    List<ReviewDto.response> getReview(Long facilityId);

    void postReview(ReviewDto.request reviewDtoReq);

    void postReviewFacility(Long facilityId);

    void deleteReview(Long facilityId, Long reviewId);

    void deleteReviewFacility(Long facilityId);

    void patchReview(Long reviewId, ReviewDto.patch reviewDtoPat);

}
