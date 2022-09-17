package com.minimi.backend.facility.category.service;

import com.minimi.backend.facility.facility.FacilityDto;
import com.minimi.backend.facility.facility.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryFacilityListener implements CategoryFacilityGetListener{

    private final FacilityService facilityService;
    @Override
    public Slice<FacilityDto.responsePage> getCategory(String categoryTitle, int page) {
        facilityService.getCategoryFacility(categoryTitle, page);
        return null;
    }
}
