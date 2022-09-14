package com.minimi.backend.mypage.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class DailyCheckDto {
    @AllArgsConstructor
    @Getter
    public static class request {
        private String username;
        private String location;
        private String facilityName;
    }

    @AllArgsConstructor
    @Getter
    public static class response {
        private String username;
        private String location;
        private Boolean check;
    }
}
