package com.minimi.backend.mypage.dailycheck;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DailyCheckMapper {
    DailyCheckDto.ResponseCalendar dailyCheckToResponse(DailyCheck dailyCheck);
}
