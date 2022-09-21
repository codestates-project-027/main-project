package com.minimi.backend.facility.facility.mapper;

import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacilityMapper {
    FacilityDto.response facilityToFacilityDtoResponse(Facility facility);
}
