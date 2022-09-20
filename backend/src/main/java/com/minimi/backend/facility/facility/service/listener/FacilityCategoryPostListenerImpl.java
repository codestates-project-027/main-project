package com.minimi.backend.facility.facility.service.listener;


import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FacilityCategoryPostListenerImpl implements FacilityCategoryPostListener {

    @Override
    @EventListener
    public void saveFacilityCategory(String CategoryCode) {

    }
}
