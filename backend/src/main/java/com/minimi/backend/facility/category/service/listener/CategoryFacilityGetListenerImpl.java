package com.minimi.backend.facility.category.service.listener;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facilitycategorylist.service.FacaMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryFacilityGetListenerImpl implements CategoryFacilityGetListener {

    private final FacaMappingService facaMappingService;
    @Override
    public Slice<ResponseFacilityDto.facilityPageFromCategory> getCategory(String categoryCode, int page) {
        return facaMappingService.getCategoryFacilitySlice(categoryCode, page);
    }
}
