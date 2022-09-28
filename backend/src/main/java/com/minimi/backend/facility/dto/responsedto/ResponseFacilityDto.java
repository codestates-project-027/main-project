package com.minimi.backend.facility.dto.responsedto;


import com.minimi.backend.facility.facility.domain.FacilityStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class ResponseFacilityDto {
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class facilityPageFromCategory{
        private Long facilityId;
        private String facilityName;
        private String facilityPhoto;
        private String address;
        private int starRate;
        private String location;
        private List<String> categoryList;
        private FacilityStatus facilityStatus;
    }
}
