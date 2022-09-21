package com.minimi.backend.facility.facility.service;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import org.springframework.data.domain.Slice;

public interface FacilityService {
    public FacilityDto.response getFacility(Long facilityId);

    public Slice<ResponseFacilityDto.facilityPageFromCategory> getNearFacilityList(String location, int page);

    public Slice<ResponseFacilityDto.facilityPageFromCategory> getCategoryFacility(String categoryCode, int page);

    public Facility postFacility(FacilityDto.request facilityDtoReq);

    public Facility patchFacility(Long facilityId, FacilityDto.patch facilityDtoPat);

    public void deleteFacility(Long facilityId);


}
