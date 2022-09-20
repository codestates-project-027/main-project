package com.minimi.backend.facility.facility.service.facilitycategortlist;

import com.minimi.backend.facility.facility.domain.facility.FacilityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacilityCategoryListServiceImpl implements FacilityCategoryListService {

    @Override
    public Slice<FacilityDto.responsePage> getCategoryFacilitySlice(String categoryCode, int page) {
        return null;
    }
}
