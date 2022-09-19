package com.minimi.backend.mypage.myFacility;


import com.minimi.backend.facility.bookmark.BookmarkDto;
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
    public ResponseEntity postMyFacility(@RequestBody BookmarkDto.request bookmarkReq){
        return new ResponseEntity(HttpStatus.CREATED);
    }
    //delete bookmark
    @DeleteMapping("/{facilityId}")
    public ResponseEntity deleteMyFacility(@PathVariable Long facilityId){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{username}")
    public ResponseEntity<MyFacilityDto.response> getMyFacilitys(@PathVariable String username) {
        return new ResponseEntity<>(myFacilityService.getMyFacilitys(username), HttpStatus.OK);
    }
}
