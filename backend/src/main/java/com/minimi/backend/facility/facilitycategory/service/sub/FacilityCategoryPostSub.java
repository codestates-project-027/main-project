package com.minimi.backend.facility.facilitycategory.service.sub;


import com.minimi.backend.facility.category.service.publisher.CategoryPostEvent;

public interface FacilityCategoryPostSub {

    void saveFacilityCategory(CategoryPostEvent categoryPostEvent);
}
