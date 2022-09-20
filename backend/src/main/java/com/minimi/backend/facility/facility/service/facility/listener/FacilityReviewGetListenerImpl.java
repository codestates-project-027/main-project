package com.minimi.backend.facility.facility.service.facility.listener;

import com.minimi.backend.facility.review.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class FacilityReviewGetListenerImpl implements FacilityReviewGetListener {
    @Override
    public Slice<ReviewDto.response> getReview(Long facilityId, int page) {
        return null;
    }
}
