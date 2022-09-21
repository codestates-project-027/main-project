package com.minimi.backend.facility.facilitycategorylist.service;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategorylist.domain.FacilityCategoryList;
import org.springframework.data.domain.Slice;

public interface FacilityCategoryListService {
    public Slice<ResponseFacilityDto.facilityPageFromCategory> getCategoryFacilitySlice(String categoryCode, int page);

    FacilityCategoryList postFacilityCategoryListEntity(FacilityCategory facilityCategory, Facility facility);
}
