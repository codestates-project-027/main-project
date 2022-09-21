package com.minimi.backend.facility.facamapping.service.listener;

import com.minimi.backend.facility.facility.service.publisher.FacilityPostEvent;

public interface FacilityPostListener {
    void saveFacilityCategoryList(FacilityPostEvent facilityPostEvent);
}
