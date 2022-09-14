package com.minimi.backend.mypage.service;

import com.minimi.backend.mypage.domain.DailyCheckDto;
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
