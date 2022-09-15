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

    @AllArgsConstructor
    @Getter
    public static class response{
        private Long facilityId;
        private String facilityName;
        private List<String> facilityPhotoList;
        private String facilityInfo;
        private String address;
        private String website;
        private String phone;
        private int reviewCount;
        private String location;
        private List<String> categoryList;
        private String status;
        private List<ReviewDto.response> reviews;
    }

}
