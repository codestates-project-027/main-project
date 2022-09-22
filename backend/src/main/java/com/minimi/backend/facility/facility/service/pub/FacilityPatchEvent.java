package com.minimi.backend.facility.facility.service.pub;

import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import lombok.Getter;

import java.util.List;

@Getter
public class FacilityPatchEvent {

    private final Long facilityId;
    private final List<FacilityCategory> facilityCategoryList;

    public FacilityPatchEvent(Long facilityId, List<FacilityCategory> facilityCategoryList) {
        this.facilityId = facilityId;
        this.facilityCategoryList = facilityCategoryList;
    }
}
