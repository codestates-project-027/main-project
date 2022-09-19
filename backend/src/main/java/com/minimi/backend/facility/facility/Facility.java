package com.minimi.backend.facility.facility;

import com.minimi.backend.facility.review.Review;

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
    private int starRate;
    private String location;
    private List<String> categoryList;
    private Long categoryId;
    private String status;
    private List<Review> reviews;
}
