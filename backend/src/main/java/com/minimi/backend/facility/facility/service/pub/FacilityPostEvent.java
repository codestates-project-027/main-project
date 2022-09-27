package com.minimi.backend.facility.facility.service.pub;

import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryDto;
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
