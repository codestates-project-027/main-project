package com.minimi.backend.facility.facilitycategory.service;

import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;

public interface FacilityCategoryService {

    public FacilityCategory postFacilityCategory(String categoryCode, String categoryTitle);

    public FacilityCategory patchFacilityCategory(String categoryCode, String categoryTitle);

    Boolean checkExistsByCategoryTitle(String categoryTitle);

    FacilityCategory getFacilityCategoryByTitle(String categoryTitle);

}
