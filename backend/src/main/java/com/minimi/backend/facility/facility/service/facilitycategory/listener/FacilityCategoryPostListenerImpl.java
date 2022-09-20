package com.minimi.backend.facility.facility.service.facilitycategory.listener;


import com.minimi.backend.facility.category.service.publisher.CategoryPostEvent;
import com.minimi.backend.facility.facility.service.facilitycategory.FacilityCategoryService;
import com.minimi.backend.facility.facility.service.facilitycategory.listener.FacilityCategoryPostListener;
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
        facilityCategoryService.postFacilityCategory(
                categoryPostEvent.getCategoryCode(), categoryPostEvent.getCategoryTitle());
    }
}
