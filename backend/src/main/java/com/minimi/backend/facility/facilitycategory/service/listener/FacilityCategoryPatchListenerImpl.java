package com.minimi.backend.facility.facilitycategory.service.listener;

import com.minimi.backend.facility.category.service.publisher.CategoryPostEvent;
import com.minimi.backend.facility.facilitycategory.service.FacilityCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FacilityCategoryPatchListenerImpl implements FacilityCategoryPatchListener{

    private final FacilityCategoryService facilityCategoryService;

    @Override
    @EventListener
    @Async
    public void patchFacilityCategory(CategoryPostEvent categoryPostEvent) {
        facilityCategoryService.patchFacilityCategory(
                categoryPostEvent.getCategoryCode(), categoryPostEvent.getCategoryTitle());
    }
}
