package com.minimi.backend.facility.domain;

import java.util.List;

public class Facility {
    private Long facilityId;
    private String facilityName;
    private String facilityPhoto;
    private List<String> facilityPhotoList;
    private String facilityInfo;
    private String address;
    private String website;
    private String phone;
    private int reviewCount;
    private String location;
    private Long categoryId;
    private String status;
    private List<Review> reviews;
}
