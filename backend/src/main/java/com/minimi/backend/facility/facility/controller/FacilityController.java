package com.minimi.backend.facility.facility.controller;


import com.minimi.backend.facility.facility.domain.facility.FacilityDto;
import com.minimi.backend.facility.facility.service.facility.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
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
        facilityService.postFacility(facilityReq);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    //patch facility
    @PatchMapping("/{facilityId}")
    public ResponseEntity patchFacility(@PathVariable Long facilityId,
                                        @RequestBody FacilityDto.patch facilityPatch){
        facilityService.patchFacility(facilityId, facilityPatch);
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }
    //delete facility
    @DeleteMapping("/{facilityId}")
    public ResponseEntity deleteFacility(@PathVariable Long facilityId) {

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //get nearFacilityList
    @GetMapping("")
    public ResponseEntity<Slice<FacilityDto.responsePage>> getNearFacilityList(@RequestParam String location, int page){
        return new ResponseEntity<>(facilityService.getNearFacilityList(location, page), HttpStatus.OK);
    }
}
