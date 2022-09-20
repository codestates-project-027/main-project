package com.minimi.backend.facility.facility.service.listener;

import com.minimi.backend.facility.facilitycategory.service.FacilityCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FacilityCategoryCheckListenerImpl implements FacilityCategoryCheckListener {

    private final FacilityCategoryService facilityCategoryService;

    @Override
    public Boolean checkExistsByCategoryCode(String categoryCode) {
        return facilityCategoryService.checkExistsByCategoryCode(categoryCode);
    }
}
