package com.minimi.backend.facility.facility.service.pub;


import lombok.Getter;

@Getter
public class FacilityDeleteReviewEvent {
    private final Long facilityId;

    public FacilityDeleteReviewEvent(Long facilityId){
        this.facilityId=facilityId;
    }
}
