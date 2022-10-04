package com.minimi.backend.mypage.dailycheck;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dailycheck")
@RequiredArgsConstructor
public class DailyCheckController {

    private final DailyCheckService dailyCheckService;

    //post dailycheck
    @PostMapping("")
    public ResponseEntity<DailyCheckDto.response> postCheck(@RequestBody DailyCheckDto.request dailyCheckDtoRequest){

        return new ResponseEntity<>(dailyCheckService.postCheck(dailyCheckDtoRequest),HttpStatus.CREATED);
    }

    //get dailychecks
    @GetMapping("{username}")
    public ResponseEntity<DailyCheckDto.ResponseCalendar> getDailyChecks(@PathVariable String username){
        return new ResponseEntity<>(dailyCheckService.getDailyChecks(username),HttpStatus.OK);
    }
}
