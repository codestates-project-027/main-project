package com.minimi.backend.facility.facilitycategory.service.sub;

import com.minimi.backend.facility.category.service.pub.CategoryPatchEvent;
import com.minimi.backend.facility.facilitycategory.service.FacilityCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableAsync
public class FacilityCategoryPatchSubImpl implements FacilityCategoryPatchSub {

    private final FacilityCategoryService facilityCategoryService;

    @Override
    @EventListener
    @Async
    public void patchFacilityCategory(CategoryPatchEvent categoryPatchEvent) {
        facilityCategoryService.patchFacilityCategory(
                categoryPatchEvent.getCategoryCode(), categoryPatchEvent.getCategoryTitle());
    }
}
