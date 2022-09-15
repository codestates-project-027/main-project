package com.minimi.backend.mypage.domain;

import com.minimi.backend.facility.domain.Facility;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class MyFacilityDto {

    @AllArgsConstructor
    @Getter
    public static class response {
        private String username;
        private List<String> facilityList;
    }
}
