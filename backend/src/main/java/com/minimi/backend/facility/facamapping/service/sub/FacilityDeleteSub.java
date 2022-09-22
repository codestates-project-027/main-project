package com.minimi.backend.facility.facamapping.service.sub;

import com.minimi.backend.facility.facility.service.pub.FacilityDeleteEvent;

public interface FacilityDeleteSub {

    void deleteFacaMapping(FacilityDeleteEvent facilityDeleteEvent);
}
