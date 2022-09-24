package com.minimi.backend.facility.facamapping.service.listener;

import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryDto;

public interface FacilityCategoryGetIdListener {
    FacilityCategoryDto.response getFacilityCategoryByCategoryCode(String categoryCode);
}
