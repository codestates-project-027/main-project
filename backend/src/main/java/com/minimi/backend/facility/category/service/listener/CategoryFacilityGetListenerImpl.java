package com.minimi.backend.facility.category.service.listener;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import com.minimi.backend.facility.facilitycategorylist.service.FacilityCategoryListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryFacilityGetListenerImpl implements CategoryFacilityGetListener {

    private final FacilityCategoryListService facilityCategoryListService;
    @Override
    public Slice<ResponseFacilityDto.facilityPageFromCategory> getCategory(String categoryCode, int page) {
        return facilityCategoryListService.getCategoryFacilitySlice(categoryCode, page);
    }
}
