package com.minimi.backend.facility.facility.service.pub;


import lombok.Getter;

@Getter
public class FacilityPostReviewEvent {

    private final Long facilityId;


    public FacilityPostReviewEvent(Long facilityId){
        this.facilityId = facilityId;
    }
}
