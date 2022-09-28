package com.minimi.backend.facility.facamapping.service.sub;


import com.minimi.backend.facility.facamapping.service.FacaMappingService;
import com.minimi.backend.facility.facility.service.pub.FacilityPatchEvent;
import com.minimi.backend.facility.facility.service.pub.FacilityPostEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableAsync
public class FacilityPatchSubImpl implements FacilityPatchSub{

    private final FacaMappingService facaMappingService;

    @Override
    @EventListener
    @Async
    public void patchFacaMapping(FacilityPatchEvent facilityPatchEvent) {
        facaMappingService.patchFacaMapping(facilityPatchEvent.getFacilityId(), facilityPatchEvent.getFacilityCategoryDtoRes());
    }
}
