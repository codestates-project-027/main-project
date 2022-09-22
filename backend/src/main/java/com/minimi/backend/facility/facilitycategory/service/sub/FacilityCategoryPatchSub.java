package com.minimi.backend.facility.facilitycategory.service.sub;

import com.minimi.backend.facility.category.service.pub.CategoryPatchEvent;

public interface FacilityCategoryPatchSub {
    void patchFacilityCategory(CategoryPatchEvent categoryPatchEvent);
}
