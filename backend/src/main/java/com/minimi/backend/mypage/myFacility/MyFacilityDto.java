package com.minimi.backend.mypage.myFacility;

import com.minimi.backend.facility.facility.FacilityDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class MyFacilityDto {
    @AllArgsConstructor
    @Getter
    public static class request{
        private String username;
        private Long facilityId;
    }

    @AllArgsConstructor
    @Getter
    public static class response {
        private String username;
        private List<FacilityDto.responseMyFacility> facilityList;
    }
}
