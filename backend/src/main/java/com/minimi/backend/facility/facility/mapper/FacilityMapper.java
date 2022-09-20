package com.minimi.backend.facility.facility.mapper;

import com.minimi.backend.facility.facility.domain.facility.Facility;
import com.minimi.backend.facility.facility.domain.facility.FacilityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacilityMapper {
    FacilityDto.response facilityToFacilityDtoResponse(Facility facility);
}
