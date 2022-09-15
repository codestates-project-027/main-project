package com.minimi.backend.facility;


import com.minimi.backend.facility.domain.Facility;
import com.minimi.backend.facility.domain.FacilityDto;
import com.minimi.backend.facility.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //get facilitys
    //post facility
    //patch facility
    //delete facility
}
