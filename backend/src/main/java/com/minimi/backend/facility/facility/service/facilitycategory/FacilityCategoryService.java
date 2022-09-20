package com.minimi.backend.facility.facility.service.facilitycategory;

import com.minimi.backend.facility.facility.domain.facilitycategory.FacilityCategory;

public interface FacilityCategoryService {

    public FacilityCategory postFacilityCategory(String categoryCode);

    Boolean checkExistsByCategoryCode(String categoryCode);
}
