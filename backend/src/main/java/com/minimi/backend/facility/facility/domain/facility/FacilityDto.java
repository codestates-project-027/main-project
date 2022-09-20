package com.minimi.backend.facility.facility.domain.facility;

import com.minimi.backend.facility.review.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class FacilityDto {

    @AllArgsConstructor
    @Getter
    public static class responsePage{
        private Long facilityId;
        private String facilityName;
        private String facilityPhoto;
        private String address;
        private int starRate;
        private String location;
        private List<String> categoryList;
        private FacilityStatus facilityStatus;
    }

    @AllArgsConstructor
    @Getter
    public static class responseMyFacility{
        private Long facilityId;
        private String facilityName;
        private String location;
        private FacilityStatus facilityStatus;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class response{
        private Long facilityId;
        private String facilityName;
        private List<String> facilityPhotoList;
        private String facilityInfo;
        private String address;
        private String website;
        private String phone;
        private int starRate;
        private String location;
        private List<String> categoryList;
        private FacilityStatus facilityStatus;
        private List<ReviewDto.response> reviews;
    }

    @Getter
    @AllArgsConstructor
    public static class request{
        private String facilityName;
        private String facilityPhoto;
        private List<String> facilityPhotoList;
        private String facilityInfo;
        private String address;
        private String website;
        private String phone;
        private String location;
        private List<String> categoryList;
    }
    @Getter
    @AllArgsConstructor
    public static class patch{
        private String facilityName;
        private String facilityPhoto;
        private List<String> facilityPhotoList;
        private String facilityInfo;
        private String address;
        private String website;
        private String phone;
        private String location;
        private List<String> categoryList;
    }

}
