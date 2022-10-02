package com.minimi.backend.mypage.myfacility;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myfacility")
@RequiredArgsConstructor
public class MyFacilityController {
    private final MyFacilityService myFacilityService;

    @PostMapping("")
    public ResponseEntity postMyFacility(@RequestBody MyFacilityDto.request myFacilityDtoReq){
        myFacilityService.postMyFacilitys(myFacilityDtoReq);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    //delete bookmark
    @DeleteMapping("/{facilityId}/{username}")
    public ResponseEntity deleteMyFacility(@PathVariable Long facilityId,
                                           @PathVariable String username){
        myFacilityService.deleteyFacilitys(facilityId, username);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{username}")
    public ResponseEntity<MyFacilityDto.response> getMyFacilitys(@PathVariable String username) {
        return new ResponseEntity<>(myFacilityService.getMyFacilitys(username), HttpStatus.OK);
    }
}
