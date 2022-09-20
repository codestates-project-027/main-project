package com.minimi.backend.facility.facilitycategory.service;

import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FacilityCategoryServiceImpl implements FacilityCategoryService {

    private final FacilityCategoryRepository facilityCategoryRepository;
    @Override
    public FacilityCategory postFacilityCategory(String categoryCode, String categoryTitle) {
        return null;
    }

    @Override
    public FacilityCategory patchFacilityCategory(String categoryCode, String categoryTitle) {
        return null;
    }

    @Override
    public Boolean checkExistsByCategoryCode(String categoryCode) {
        return facilityCategoryRepository.existsByCategoryCode(categoryCode);
    }

}
