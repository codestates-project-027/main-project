package com.minimi.backend.facility.review.service.sub;

import com.minimi.backend.facility.facility.service.pub.FacilityPostReviewEvent;

public interface FacilityPostReviewSub {

    void saveReviewFacility(FacilityPostReviewEvent facilityPostReviewEvent);
}
