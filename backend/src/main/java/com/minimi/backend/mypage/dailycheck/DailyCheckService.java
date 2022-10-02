package com.minimi.backend.mypage.dailycheck;

import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facility.domain.FacilityRepository;
import com.minimi.backend.mypage.dailycheck.pub.MiracleScoreAddEvent;
import com.minimi.backend.mypage.myfacility.MyFacility;
import com.minimi.backend.mypage.myfacility.MyFacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DailyCheckService {

    private final DailyCheckRepository dailyCheckRepository;
    private final DailyCheckMapper dailyCheckMapper;
    private final MyFacilityRepository myFacilityRepository;
    private final FacilityRepository facilityRepository;
    private final ApplicationEventPublisher eventPublisher;


    public DailyCheckDto.response postCheck(DailyCheckDto.request dailyCheckDtoRequest) {
        //list에 add true
        //bach로 날짜(false), 월마다 갱신
        Long facilityId = dailyCheckDtoRequest.getFacilityId();
        String username = dailyCheckDtoRequest.getUsername();
        String location = dailyCheckDtoRequest.getLocation();

        checkMyFacility(username, facilityId);

        Facility facility = facilityRepository.findById(facilityId)
                .orElseThrow(()->new NullPointerException("not found facility"));

        locationCheck(location, facility);

        if (!dailyCheckRepository.existsByUsername(username)){
            List<String> checklist = new ArrayList<>();
            checklist.add("true");
            LocalDate localDate = LocalDate.now();
            dailyCheckRepository.save(new DailyCheck(username,checklist,localDate));
            eventPublisher.publishEvent(new MiracleScoreAddEvent(username));
            return null;
        }

        DailyCheck dailyCheck = dailyCheckRepository.findByUsername(username);

        if (Objects.equals(dailyCheck.getUpdate(), LocalDate.now())){
            return null;
        }
        dailyCheck.getCheckList().add("true");
        dailyCheck.setUpdate(LocalDate.now());
        dailyCheckRepository.save(dailyCheck);
        eventPublisher.publishEvent(new MiracleScoreAddEvent(username));
        return null;
    }

    public DailyCheckDto.ResponseCalendar getDailyChecks(String username) {
        if (!dailyCheckRepository.existsByUsername(username)){
            throw new NullPointerException("not found user");
        };

        DailyCheck dailyCheck = dailyCheckRepository.findByUsername(username);

        return dailyCheckMapper.dailyCheckToResponse(dailyCheck);
    }

    private void checkMyFacility(String username, Long facilityId){
        if (!myFacilityRepository.existsByUsername(username)){
            throw new RuntimeException("not found my facility");
        }
        MyFacility myFacility = myFacilityRepository.findByUsername(username);

        if (!myFacility.getFacilityIdList().contains(String.valueOf(facilityId))){
            throw new RuntimeException("not found my facility");
        }
    }

    private void locationCheck(String location, Facility facility) {
        String facilityLocation = facility.getLocation();
        String[] facilityLocations = facilityLocation.split(", ");
        String[] locations = location.split(", ");
        if (!facilityLocations[0].substring(0, 6).equals(locations[0].substring(0, 6)) || !facilityLocations[1].substring(0, 7).equals(locations[1].substring(0, 7))) {
            throw new RuntimeException("not equal location");
        }
    }
}
