package com.minimi.backend.facility.facamapping.service.listener;

import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;

public interface FacilityCategoryGetIdListener {
    FacilityCategory getFacilityCategoryByCategoryCode(String categoryCode);
}
