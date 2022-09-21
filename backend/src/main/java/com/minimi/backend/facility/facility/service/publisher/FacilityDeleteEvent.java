package com.minimi.backend.facility.facility.service.publisher;

import lombok.Getter;

@Getter
public class FacilityDeleteEvent{

    private final Long facilityId;

    public FacilityDeleteEvent(Long facilityId){
        this.facilityId = facilityId;

    }
}