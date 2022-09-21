package com.minimi.backend.facility.facility.service.listener;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facamapping.service.FacaMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FacaMappingGetListenerImpl implements FacaMappingGetListener {

    private final FacaMappingService facaMappingService;

    @Override
    public Slice<ResponseFacilityDto.facilityPageFromCategory> getFacilityFromCategory(String categoryCode, int page) {
        return facaMappingService.getCategoryFacilitySlice(categoryCode, page);
    }
}
