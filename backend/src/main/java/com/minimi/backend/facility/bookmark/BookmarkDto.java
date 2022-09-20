package com.minimi.backend.facility.bookmark;

import com.minimi.backend.facility.facility.domain.FacilityDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class BookmarkDto {

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
