package com.minimi.backend.facility.facamapping.service.sub;


import com.minimi.backend.facility.facility.service.pub.FacilityPostEvent;
import com.minimi.backend.facility.facamapping.service.FacaMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableAsync
public class FacilityPostSubImpl implements FacilityPostSub {

    private final FacaMappingService facaMappingService;

    @Override
    @EventListener
    @Async
    public void saveFacaMapping(FacilityPostEvent facilityPostEvent) {
        facaMappingService.postFacaMapping(
                facilityPostEvent.getFacilityCategory(),
                facilityPostEvent.getFacility());
    }
}
