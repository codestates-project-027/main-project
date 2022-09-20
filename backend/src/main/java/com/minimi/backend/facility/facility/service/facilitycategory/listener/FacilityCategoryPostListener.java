package com.minimi.backend.facility.facility.service.facilitycategory.listener;


import com.minimi.backend.facility.category.service.publisher.CategoryPostEvent;

public interface FacilityCategoryPostListener {

    void saveFacilityCategory(CategoryPostEvent categoryPostEvent);
}
