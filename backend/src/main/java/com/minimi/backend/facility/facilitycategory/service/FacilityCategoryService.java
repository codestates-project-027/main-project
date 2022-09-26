package com.minimi.backend.facility.facilitycategory.service;

import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryDto;

public interface FacilityCategoryService {

    public void postFacilityCategory(String categoryCode, String categoryTitle);

    public void patchFacilityCategory(String categoryCode, String categoryTitle);

    Boolean checkExistsByCategoryTitle(String categoryTitle);

    FacilityCategoryDto.response getFacilityCategoryByCategoryCode(String categoryCode);

    FacilityCategory getFacilityCategoryByTitle(String categoryTitle);

}
