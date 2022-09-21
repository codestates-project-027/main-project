package com.minimi.backend.facility.facility.service.listener;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import org.springframework.data.domain.Slice;

public interface FacaMappingGetListener {
    Slice<ResponseFacilityDto.facilityPageFromCategory> getFacilityFromCategory(String categoryCode, int page);
}
