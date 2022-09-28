package com.minimi.backend.facility.facamapping.service.sub;

import com.minimi.backend.facility.facility.service.pub.FacilityPatchEvent;

public interface FacilityPatchSub {
    /**
     * @deprecated patchEvent deprecated
     * @param facilityPatchEvent
     */
    void patchFacaMapping(FacilityPatchEvent facilityPatchEvent);
}
