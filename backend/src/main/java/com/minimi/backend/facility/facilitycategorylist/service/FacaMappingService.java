package com.minimi.backend.facility.facilitycategorylist.service;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategorylist.domain.FacaMapping;
import org.springframework.data.domain.Slice;

public interface FacaMappingService {
    public Slice<ResponseFacilityDto.facilityPageFromCategory> getCategoryFacilitySlice(String categoryCode, int page);

    FacaMapping postFacilityCategoryListEntity(FacilityCategory facilityCategory, Facility facility);
}
