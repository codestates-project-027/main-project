package com.minimi.backend.facility.facilitycategorylist.service.listener;


import com.minimi.backend.facility.facility.service.publisher.FacilityPostEvent;
import com.minimi.backend.facility.facilitycategorylist.service.FacaMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FacilityPostListenerImpl implements FacilityPostListener{

    private final FacaMappingService facaMappingService;

    @Override
    @EventListener
    @Async
    public void saveFacilityCategoryList(FacilityPostEvent facilityPostEvent) {
        facaMappingService.postFacilityCategoryListEntity(
                facilityPostEvent.getFacilityCategory(),
                facilityPostEvent.getFacility());
    }
}
