package com.minimi.backend.facility.facamapping.service;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facamapping.mapper.FacaMappingMapper;
import com.minimi.backend.facility.facamapping.service.listener.FacilityCategoryGetIdListener;
import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facamapping.domain.FacaMapping;
import com.minimi.backend.facility.facamapping.domain.FacaMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class FacaMappingServiceImpl implements FacaMappingService {

    private final FacaMappingRepository facaMappingRepository;
    private final FacilityCategoryGetIdListener facilityCategoryGetIdListener;
    private final FacaMappingMapper facaMappingMapper;


    @Override
    public Slice<ResponseFacilityDto.facilityPageFromCategory> getCategoryFacilitySlice(String categoryCode, int page) {

        FacilityCategory facilityCategory = facilityCategoryGetIdListener
                .getFacilityCategoryByCategoryCode(categoryCode);


        Slice<FacaMapping> facaMappingSlice =facaMappingRepository
                .findByFacilityCategory(facilityCategory,
                        PageRequest.of(page-1,10, Sort.by("facaMappingId").descending()));
        checkNullSliceContent(facaMappingSlice);


        List<ResponseFacilityDto.facilityPageFromCategory> resultList = new ArrayList<>();
        facaMappingSlice.getContent().forEach(facaMapping -> {
            resultList.add(facaMappingMapper.FacilityToResponseFacilityDto(facaMapping.getFacility()));
        });
        return new SliceImpl<>(resultList,facaMappingSlice.getPageable(),facaMappingSlice.hasNext());
    }

    private Boolean checkNullSliceContent(Slice<FacaMapping> facaMappingSlice) {
        if (facaMappingSlice.getContent().size()>0) return true;
        throw new NullPointerException("Null Slice Content");
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
