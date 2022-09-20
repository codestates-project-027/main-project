package com.minimi.backend.facility.facility.service.listener;

import com.minimi.backend.facility.facility.domain.FacilityDto;
import org.springframework.data.domain.Slice;

public interface FacilityCategoryListGetListener {
    Slice<FacilityDto.responsePage> getFacilityFromCategory(String categoryCode, int page);
}
