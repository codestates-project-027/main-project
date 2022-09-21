package com.minimi.backend.facility.facamapping.mapper;


import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.Facility;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacaMappingMapper {
    ResponseFacilityDto.facilityPageFromCategory FacilityToResponseFacilityDto(Facility facility);
}
