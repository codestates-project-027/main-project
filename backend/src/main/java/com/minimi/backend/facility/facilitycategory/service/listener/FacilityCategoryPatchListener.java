package com.minimi.backend.facility.facilitycategory.service.listener;

import com.minimi.backend.facility.category.service.publisher.CategoryPostEvent;

public interface FacilityCategoryPatchListener {
    void patchFacilityCategory(CategoryPostEvent categoryPostEvent);
}
