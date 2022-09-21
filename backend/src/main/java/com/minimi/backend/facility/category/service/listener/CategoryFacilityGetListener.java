package com.minimi.backend.facility.category.service.listener;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import org.springframework.data.domain.Slice;

public interface CategoryFacilityGetListener {
    Slice<ResponseFacilityDto.facilityPageFromCategory> getCategory(String categoryCode, int page);
}
