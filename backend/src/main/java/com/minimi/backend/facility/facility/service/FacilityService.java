package com.minimi.backend.facility.facility.service;

import com.minimi.backend.facility.facility.domain.facility.Facility;
import com.minimi.backend.facility.facility.domain.facility.FacilityDto;
import com.minimi.backend.facility.facility.domain.facilitycategory.FacilityCategory;
import org.springframework.data.domain.Slice;

public interface FacilityService {
    public FacilityDto.response getFacility(Long facilityId);

    public Slice<FacilityDto.responsePage> getNearFacilityList(String location, int page);

    public Slice<FacilityDto.responsePage> getCategoryFacility(String categoryTitle, int page);

    public Facility postFacility(FacilityDto.request facilityDtoReq);

    public Facility patchFacility(FacilityDto.patch facilityDtoPat);

    public void deleteFacility(Long facilityId);


}
