package com.minimi.backend.facility.facility.service.facilitycategory;

import com.minimi.backend.facility.facility.domain.facilitycategory.FacilityCategory;
import com.minimi.backend.facility.facility.domain.facilitycategory.FacilityCategoryRepository;
import com.minimi.backend.facility.facility.service.facilitycategory.FacilityCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FacilityCategoryServiceImpl implements FacilityCategoryService {

    private final FacilityCategoryRepository facilityCategoryRepository;
    @Override
    public FacilityCategory postFacilityCategory(String categoryCode) {
        return null;
    }

    @Override
    public Boolean checkExistsByCategoryCode(String categoryCode) {
        return facilityCategoryRepository.existsByCategoryCode(categoryCode);
    }
}
