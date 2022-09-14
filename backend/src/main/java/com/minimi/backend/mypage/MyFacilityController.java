package com.minimi.backend.mypage;


import com.minimi.backend.mypage.domain.MyFacilityDto;
import com.minimi.backend.mypage.service.MyFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myFacility")
@RequiredArgsConstructor
public class MyFacilityController {

    private final MyFacilityService myFacilityService;

    //get myfailitys
    @GetMapping("{username}")
    public ResponseEntity<MyFacilityDto.response> getMyFacilitys(@PathVariable String username) {
        return new ResponseEntity<>(myFacilityService.getMyFacilitys(username), HttpStatus.OK);
    }

}
