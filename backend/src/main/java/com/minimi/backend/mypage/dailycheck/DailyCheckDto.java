package com.minimi.backend.mypage.dailycheck;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class DailyCheckDto {
    @AllArgsConstructor
    @Getter
    public static class request {
        private String username;
        private String location;
        private Long facilityId;
    }

    @AllArgsConstructor
    @Getter
    public static class response {
        private String username;
        private Long facilityId;
        private Boolean check;
    }

    @AllArgsConstructor
    @Getter
    public static class ResponseCalendar {
        private String username;
        private List<String> checkDailyList;
    }
}
