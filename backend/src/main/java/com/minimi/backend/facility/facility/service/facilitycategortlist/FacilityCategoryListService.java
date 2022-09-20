package com.minimi.backend.facility.facility.service.facilitycategortlist;

import com.minimi.backend.facility.facility.domain.facility.FacilityDto;
import org.springframework.data.domain.Slice;

public interface FacilityCategoryListService {
    public Slice<FacilityDto.responsePage> getCategoryFacilitySlice(String categoryCode, int page);
}
