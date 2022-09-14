package com.minimi.backend.facility.domain;

import java.util.List;

public class Facility {
    private Long facilityId;
    private String facilityName;
    private List<String> facilityPhoto;
    private String facilityInfo;
    private String address;
    private String website;
    private String phone;
    private String reviewCount;
    private String location;
    private Long categoryId;
    private String status;
    private List<Review> reviews;
}
