package com.minimi.backend.facility.facamapping.service.sub;

import com.minimi.backend.facility.facility.service.pub.FacilityPatchEvent;

public interface FacilityPatchSub {
    void patchFacaMapping(FacilityPatchEvent facilityPatchEvent);
}
