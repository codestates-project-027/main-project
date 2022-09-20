package com.minimi.backend.facility.category.service.listener;

import com.minimi.backend.facility.facility.domain.facility.FacilityDto;
import com.minimi.backend.facility.facility.service.facility.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryFacilityGetListenerImpl implements CategoryFacilityGetListener {

    private final FacilityService facilityService;
    @Override
    public Slice<FacilityDto.responsePage> getCategory(String categoryCode, int page) {
        return facilityService.getCategoryFacility(categoryCode, page);
    }
}
