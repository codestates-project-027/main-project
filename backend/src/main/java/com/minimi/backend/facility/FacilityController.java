package com.minimi.backend.facility;


import com.minimi.backend.facility.domain.Facility;
import com.minimi.backend.facility.domain.FacilityDto;
import com.minimi.backend.facility.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facility")
@RequiredArgsConstructor
public class FacilityController {

    private final FacilityService facilityService;

    //get facility
    @GetMapping("/{facilityId}")
    public ResponseEntity<FacilityDto.response> getFacility(@PathVariable Long facilityId){
        return new ResponseEntity<>(facilityService.getFacility(facilityId), HttpStatus.OK);
    }
    //post facility
    @PostMapping("")
    public ResponseEntity postFacility(@RequestBody FacilityDto.request facilityReq){
        return new ResponseEntity(HttpStatus.CREATED);
    }

    //patch facility
    //delete facility
    //get nearFacilityList
}
