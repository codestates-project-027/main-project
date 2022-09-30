package com.minimi.backend.mypage.myfacility;

import com.minimi.backend.facility.facility.domain.FacilityDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Setter
    @NoArgsConstructor
    public static class response {
        private String username;
        private List<FacilityDto.responseMyFacility> facilityList;
    }
}
