package com.minimi.backend.facility.facility.service.listener;

import com.minimi.backend.facility.review.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FacilityReviewGetListenerImpl implements FacilityReviewGetListener {
    @Override
    public List<ReviewDto.response> getReview(Long facilityId) {
        return null;
    }
}
