package com.minimi.backend.facility.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class FacilityDto {

    @AllArgsConstructor
    @Getter
    public static class responsePage{
        private Long facilityId;
        private String facilityName;
        private String facilityPhoto;
        private String address;
        private int reviewCount;
        private String location;
        private String status;
    }

}
