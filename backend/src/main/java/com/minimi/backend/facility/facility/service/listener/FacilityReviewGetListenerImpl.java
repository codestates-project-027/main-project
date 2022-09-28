package com.minimi.backend.facility.facility.service.listener;

import com.minimi.backend.facility.review.domain.ReviewDto;
import com.minimi.backend.facility.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FacilityReviewGetListenerImpl implements FacilityReviewGetListener {

    private final ReviewService reviewService;
    @Override
    public List<ReviewDto.response> getReview(Long facilityId) {
        return reviewService.getReview(facilityId);
    }
}
