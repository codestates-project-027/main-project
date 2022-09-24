package com.minimi.backend.facility.facility.service.listener;


import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryDto;

public interface FacilityCategoryCheckListener {
    Boolean checkExistsByCategoryTitle(String categoryTitle);

    FacilityCategoryDto.response getFacilityCategoryByTitle(String categoryTitle);
}
