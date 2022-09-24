package com.minimi.backend.facility.facility.service.pub;

import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryDto;
import lombok.Getter;

@Getter
public class FacilityPostEvent{


    private final FacilityCategoryDto.response facilityCategoryDtoRes;
    private final Facility facility;

    public FacilityPostEvent(FacilityCategoryDto.response facilityCategoryDtoRes, Facility facility) {
        this.facilityCategoryDtoRes = facilityCategoryDtoRes;
        this.facility = facility;
    }
}
