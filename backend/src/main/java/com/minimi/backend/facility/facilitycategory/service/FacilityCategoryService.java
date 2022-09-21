package com.minimi.backend.facility.facilitycategory.service;

import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;

public interface FacilityCategoryService {

    public FacilityCategory postFacilityCategory(String categoryCode, String categoryTitle);

    public FacilityCategory patchFacilityCategory(String categoryCode, String categoryTitle);

    Boolean checkExistsByCategoryTitle(String categoryTitle);

    Long getFacilityCategoryIdByCode(String categoryCode);

    FacilityCategory getFacilityCategoryByTitle(String categoryTitle);

}
