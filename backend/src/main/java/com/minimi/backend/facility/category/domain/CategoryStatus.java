package com.minimi.backend.facility.category.domain;

public enum CategoryStatus {
    ACTIVE("활성"),
    INACTIVE("비활성");

    private String value;
    CategoryStatus(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}