package com.minimi.backend.facility.category.service;

import com.minimi.backend.facility.facility.FacilityDto;
import org.springframework.data.domain.Slice;

public interface CategoryFacilityGetListener {
    Slice<FacilityDto.responsePage> getCategory(String categoryTitle, int page);
}
