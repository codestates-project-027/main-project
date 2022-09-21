package com.minimi.backend.facility.facilitycategorylist.service;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import org.springframework.data.domain.Slice;

public interface FacilityCategoryListService {
    public Slice<ResponseFacilityDto.facilityPageFromCategory> getCategoryFacilitySlice(String categoryCode, int page);
}
