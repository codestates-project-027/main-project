package com.minimi.backend.facility.facamapping.service;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facamapping.domain.FacaMapping;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryDto;
import org.springframework.data.domain.Slice;


public interface FacaMappingService {
    /**
     * @param categoryCode
     * @param page
     * @return Slice<ResponseFacilityDto.facilityPageFromCategory>
     */
    public Slice<ResponseFacilityDto.facilityPageFromCategory> getCategoryFacilitySlice(String categoryCode, int page);

    /**
     * @param facilityCategoryDtoRes
     * @param facility
     * @return FacaMapping
     */
    void postFacaMapping(FacilityCategoryDto.response facilityCategoryDtoRes, Facility facility);

    /**
     * @param facilityId
     */
    void deleteFacaMapping(Long facilityId);

    /**
     * @deprecated exists only testCode
     * @param facilityId
     * @param facilityCategoryDtoRes
     * @return FacaMapping
     */
    void patchFacaMapping(Long facilityId, FacilityCategoryDto.response facilityCategoryDtoRes);

}
