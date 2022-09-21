package com.minimi.backend.facility.facamapping.service;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facamapping.domain.FacaMapping;
import com.minimi.backend.facility.facamapping.domain.FacaMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacaMappingServiceImpl implements FacaMappingService {

    private final FacaMappingRepository facaMappingRepository;

    @Override
    public Slice<ResponseFacilityDto.facilityPageFromCategory> getCategoryFacilitySlice(String categoryCode, int page) {
        return null;
    }

    @Override
    public FacaMapping postFacilityCategoryListEntity(FacilityCategory facilityCategory, Facility facility) {
        //null blank check
        blankAndNullCheck(facilityCategory);
        blankAndNullCheck(facility);
        blankAndNullCheck(facilityCategory.getFacilityCategoryId());
        blankAndNullCheck(facility.getFacilityId());

        return facaMappingRepository.save(FacaMapping
                .builder()
                .facilityCategory(facilityCategory)
                .facility(facility).build());
    }

    public Boolean blankAndNullCheck(Object value) {
        if (value==null||String.valueOf(value).isBlank()) {
            throw new NullPointerException("Null Value");
        }
        return true;
    }
}
