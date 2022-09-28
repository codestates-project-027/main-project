package com.minimi.backend.facility.facility.service.pub;

import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryDto;
import lombok.Getter;

import java.util.List;



@Getter
public class FacilityPatchEvent {

    private final Long facilityId;
    private final FacilityCategoryDto.response facilityCategoryDtoRes;

    /**
     * @deprecated patchEvent replaced deleteEvent and postEvent
     * @param facilityId
     * @param facilityCategoryDtoRes
     */
    public FacilityPatchEvent(Long facilityId, FacilityCategoryDto.response facilityCategoryDtoRes) {
        this.facilityId = facilityId;
        this.facilityCategoryDtoRes = facilityCategoryDtoRes;
    }
}
