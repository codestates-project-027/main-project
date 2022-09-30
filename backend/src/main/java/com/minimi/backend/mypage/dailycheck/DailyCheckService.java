package com.minimi.backend.mypage.dailycheck;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DailyCheckService {


    public DailyCheckDto.response postCheck(DailyCheckDto.request dailyCheckDtoRequest) {
        return null;
    }

    public DailyCheckDto.ResponseCalendar getDailyChecks(String username) {
        return null;
    }
}
