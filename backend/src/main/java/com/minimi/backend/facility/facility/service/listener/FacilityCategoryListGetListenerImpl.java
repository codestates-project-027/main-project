package com.minimi.backend.facility.facility.service.listener;

import com.minimi.backend.facility.facility.domain.FacilityDto;
import com.minimi.backend.facility.facilitycategorylist.service.FacilityCategoryListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FacilityCategoryListGetListenerImpl implements FacilityCategoryListGetListener{

    private final FacilityCategoryListService facilityCategoryListService;

    @Override
    public Slice<FacilityDto.responsePage> getFacilityFromCategory(String categoryCode, int page) {
        return facilityCategoryListService.getCategoryFacilitySlice(categoryCode, page);
    }
}
