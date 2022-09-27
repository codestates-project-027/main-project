package com.minimi.backend.facility.review.service.sub;

import com.minimi.backend.facility.facility.service.pub.FacilityPostReviewEvent;
import com.minimi.backend.facility.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@EnableAsync
public class FacilityPostReviewSubImpl implements FacilityPostReviewSub {

    private final ReviewService reviewService;

    @Override
    @EventListener
    @Async
    public void saveReviewFacility(FacilityPostReviewEvent facilityPostReviewEvent) {
        reviewService.postReviewFacility(facilityPostReviewEvent.getFacilityId());
    }

}
