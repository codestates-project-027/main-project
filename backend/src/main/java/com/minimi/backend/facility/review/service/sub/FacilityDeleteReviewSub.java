package com.minimi.backend.facility.review.service.sub;

import com.minimi.backend.facility.facility.service.pub.FacilityDeleteReviewEvent;

public interface FacilityDeleteReviewSub {

    void deleteReviewFacility(FacilityDeleteReviewEvent facilityDeleteReviewEvent);
}
