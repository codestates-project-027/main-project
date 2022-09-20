package com.minimi.backend.facility.facility.service.publisher;

import lombok.Getter;

@Getter
public class FacilityPostEvent{

    private final Long facilityId;

    public FacilityPostEvent(Long facilityId) {
        this.facilityId = facilityId;

    }
}
