package com.minimi.backend.facility.facility.service.listener;


import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;

public interface FacilityCategoryCheckListener {
    Boolean checkExistsByCategoryTitle(String categoryTitle);

    FacilityCategory getFacilityCategoryByTitle(String categoryTitle);
}
