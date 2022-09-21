package com.minimi.backend.facility.facility.domain;

public enum FacilityStatus {
    ACTIVE("영업중"),
    INACTIVE("영업종료"),
    PENDING("보류중");

    private String value;
    FacilityStatus(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}

