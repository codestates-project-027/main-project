package com.minimi.backend.facility.facility.service.pub;

import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import lombok.Getter;

import java.util.List;

@Getter
public class FacilityPatchEvent {

    private final Long facilityId;
    private final FacilityCategory facilityCategory;

    public FacilityPatchEvent(Long facilityId, FacilityCategory facilityCategory) {
        this.facilityId = facilityId;
        this.facilityCategory = facilityCategory;
    }
}
