package com.minimi.backend.facility.facamapping.service;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facamapping.mapper.FacaMappingMapper;
import com.minimi.backend.facility.facamapping.service.listener.FacilityCategoryGetIdListener;
import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facamapping.domain.FacaMapping;
import com.minimi.backend.facility.facamapping.domain.FacaMappingRepository;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryDto;
import com.minimi.backend.facility.facilitycategory.mapper.FacilityCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class FacaMappingServiceImpl implements FacaMappingService {

    private final FacaMappingRepository facaMappingRepository;
    private final FacilityCategoryGetIdListener facilityCategoryGetIdListener;
    private final FacaMappingMapper facaMappingMapper;
    private final FacilityCategoryMapper facilityCategoryMapper;


    @Override
    public Slice<ResponseFacilityDto.facilityPageFromCategory> getCategoryFacilitySlice(String categoryCode, int page) {

        FacilityCategory facilityCategory = facilityCategoryGetIdListener.getFacilityCategoryByCategoryCode(categoryCode);


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

    @Override
    public void postFacaMapping(FacilityCategory facilityCategory, Facility facility) {
        //null blank check
        blankAndNullCheck(facilityCategory);
        blankAndNullCheck(facility);
        blankAndNullCheck(facilityCategory.getFacilityCategoryId());
        blankAndNullCheck(facility.getFacilityId());

        facaMappingRepository.save(FacaMapping
                .builder()
                .facilityCategory(facilityCategory)
                .facility(facility)
                .facilityCategoryId(facilityCategory.getFacilityCategoryId())
                .facilityId(facility.getFacilityId())
                .build());
    }

    @Override
    @Transactional
    public void deleteFacaMapping(Long facilityId) {

        if (!facaMappingRepository.existsByFaId(facilityId)) return;

        facaMappingRepository.deleteAllByFaId(facilityId);
    }

    @Override
    @Transactional
    public void patchFacaMapping(Long facilityId, FacilityCategoryDto.response facilityCategoryDtoRes) {

        blankAndNullCheck(facilityId);
        blankAndNullCheck(facilityCategoryDtoRes);

        if (!facaMappingRepository.existsByFaId(facilityId)) throw new NullPointerException("Not Found FacaMapping");

        FacilityCategory facilityCategory = facilityCategoryMapper
                .facilityCategoryDtoResponseToFacilityCategory(facilityCategoryDtoRes);
        FacaMapping facaMapping = facaMappingRepository
                .findByFaIdAndFacaId(facilityId, facilityCategory.getFacilityCategoryId());

        facaMapping.setFacilityCategory(facilityCategory);
        facaMapping.setFacaId(facilityCategory.getFacilityCategoryId());
        facaMappingRepository.save(facaMapping);
    }

    public Boolean blankAndNullCheck(Object value) {
        if (value==null||String.valueOf(value).isBlank()) {
            throw new NullPointerException("Null Value");
        }
        return true;
    }

    private Boolean checkNullSliceContent(Slice<FacaMapping> facaMappingSlice) {
        if (facaMappingSlice.getContent().size()>0) return true;
        throw new NullPointerException("Null Slice Content");
    }
}
