package com.minimi.backend.facility.facility.service.publisher;

import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import lombok.Getter;

@Getter
public class FacilityPostEvent{


    private final FacilityCategory facilityCategory;
    private final Facility facility;

    public FacilityPostEvent(FacilityCategory facilityCategory, Facility facility) {
        this.facilityCategory = facilityCategory;
        this.facility = facility;
    }
}
