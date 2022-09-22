package com.minimi.backend.facility.facilitycategory.service.sub;

import com.minimi.backend.facility.category.service.publisher.CategoryPatchEvent;
import com.minimi.backend.facility.category.service.publisher.CategoryPostEvent;

public interface FacilityCategoryPatchSub {
    void patchFacilityCategory(CategoryPatchEvent categoryPatchEvent);
}
