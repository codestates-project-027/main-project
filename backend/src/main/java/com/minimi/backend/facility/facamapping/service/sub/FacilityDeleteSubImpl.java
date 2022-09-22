package com.minimi.backend.facility.facamapping.service.sub;


import com.minimi.backend.facility.facamapping.service.FacaMappingService;
import com.minimi.backend.facility.facility.service.pub.FacilityDeleteEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;


@Component
@RequiredArgsConstructor
public class FacilityDeleteSubImpl implements FacilityDeleteSub {

    private final FacaMappingService facaMappingService;

    @Override
    @EventListener
    public void deleteFacaMapping(FacilityDeleteEvent facilityDeleteEvent) {
        facaMappingService.deleteFacaMapping(facilityDeleteEvent.getFacilityId());
    }
}
