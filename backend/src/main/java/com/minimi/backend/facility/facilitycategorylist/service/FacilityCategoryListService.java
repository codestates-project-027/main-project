package com.minimi.backend.facility.facilitycategorylist.service;

import com.minimi.backend.facility.facility.domain.FacilityDto;
import org.springframework.data.domain.Slice;

public interface FacilityCategoryListService {
    public Slice<FacilityDto.responsePage> getCategoryFacilitySlice(String categoryCode, int page);
}
