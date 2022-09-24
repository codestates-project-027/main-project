package com.minimi.backend.facility.facilitycategory.mapper;


import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacilityCategoryMapper {
    FacilityCategoryDto.response facilityCategoryToFacilityCategoryDtoResponse(FacilityCategory facilityCategory);

    FacilityCategory facilityCategoryDtoResponseToFacilityCategory(FacilityCategoryDto.response facilityCategoryDtoResponse);
}
