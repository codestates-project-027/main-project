package com.minimi.backend.facility.facility.service.listener;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import org.springframework.data.domain.Slice;

public interface FacilityCategoryListGetListener {
    Slice<ResponseFacilityDto.facilityPageFromCategory> getFacilityFromCategory(String categoryCode, int page);
}
