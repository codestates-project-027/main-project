package com.minimi.backend.facility.facility.service.listener;


import com.minimi.backend.facility.category.service.publisher.CategoryPostEvent;
import com.minimi.backend.facility.facility.domain.facilitycategory.FacilityCategory;
import com.minimi.backend.facility.facility.service.FacilityCategoryService;
import com.minimi.backend.facility.facility.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FacilityCategoryPostListenerImpl implements FacilityCategoryPostListener {

    private final FacilityCategoryService facilityCategoryService;

    @Override
    @EventListener
    @Async
    public void saveFacilityCategory(CategoryPostEvent categoryPostEvent) {
        facilityCategoryService.postFacilityCategory(categoryPostEvent.getCategoryCode());
    }
}
