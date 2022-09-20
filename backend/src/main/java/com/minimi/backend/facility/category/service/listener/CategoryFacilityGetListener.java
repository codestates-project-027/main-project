package com.minimi.backend.facility.category.service.listener;

import com.minimi.backend.facility.facility.domain.facility.FacilityDto;
import org.springframework.data.domain.Slice;

public interface CategoryFacilityGetListener {
    Slice<FacilityDto.responsePage> getCategory(String categoryCode, int page);
}
