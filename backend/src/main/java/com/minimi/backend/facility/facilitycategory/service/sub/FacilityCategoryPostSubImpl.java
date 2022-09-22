package com.minimi.backend.facility.facilitycategory.service.sub;


import com.minimi.backend.facility.category.service.publisher.CategoryPostEvent;
import com.minimi.backend.facility.facilitycategory.service.FacilityCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FacilityCategoryPostSubImpl implements FacilityCategoryPostSub {

    private final FacilityCategoryService facilityCategoryService;

    @Override
    @EventListener
    @Async
    public void saveFacilityCategory(CategoryPostEvent categoryPostEvent) {
        facilityCategoryService.postFacilityCategory(
                categoryPostEvent.getCategoryCode(), categoryPostEvent.getCategoryTitle());
    }
}
