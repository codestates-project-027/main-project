package com.minimi.backend.facility.facamapping.service.sub;

import com.minimi.backend.facility.facility.service.pub.FacilityPostEvent;


public interface FacilityPostSub {
    void saveFacaMapping(FacilityPostEvent facilityPostEvent);
}
