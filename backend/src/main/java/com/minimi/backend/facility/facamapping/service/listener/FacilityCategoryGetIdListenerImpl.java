package com.minimi.backend.facility.facamapping.service.listener;


import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryDto;
import com.minimi.backend.facility.facilitycategory.service.FacilityCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FacilityCategoryGetIdListenerImpl implements FacilityCategoryGetIdListener {

    private final FacilityCategoryService facilityCategoryService;

    @Override
    public FacilityCategoryDto.response getFacilityCategoryByCategoryCode(String categoryCode) {
        return facilityCategoryService.getFacilityCategoryByCategoryCode(categoryCode);
    }
}
