package com.minimi.backend.facility.facilitycategorylist.service.listener;

import com.minimi.backend.facility.category.service.publisher.CategoryPostEvent;
import com.minimi.backend.facility.facility.service.publisher.FacilityPostEvent;

public interface FacilityPostListener {
    void saveFacilityCategoryList(FacilityPostEvent facilityPostEvent);
}
