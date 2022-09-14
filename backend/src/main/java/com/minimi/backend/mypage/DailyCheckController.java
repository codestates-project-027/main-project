package com.minimi.backend.mypage;


import com.minimi.backend.mypage.domain.DailyCheckDto;
import com.minimi.backend.mypage.service.DailyCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dailyCheck")
@RequiredArgsConstructor
public class DailyCheckController {

    private final DailyCheckService dailyCheckService;

    //post dailycheck
    @GetMapping("")
    public ResponseEntity<DailyCheckDto.response> postCheck(@RequestBody DailyCheckDto.request dailyCheckDtoRequest){

        return new ResponseEntity<>(dailyCheckService.postCheck(dailyCheckDtoRequest),HttpStatus.CREATED);
    }

    //get dailychecks
}
