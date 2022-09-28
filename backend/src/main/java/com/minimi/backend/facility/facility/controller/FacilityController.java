package com.minimi.backend.facility.facility.controller;


import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import com.minimi.backend.facility.facility.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    public ResponseEntity postFacility(@RequestPart(value = "request") FacilityDto.request facilityReq,
                                       @RequestPart(value = "file", required = false) List<MultipartFile> multipartFileList){
        facilityService.postFacility(multipartFileList, facilityReq);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    //patch facility
    @PatchMapping("/{facilityId}")
    public ResponseEntity patchFacility(@PathVariable Long facilityId,
                                        @RequestPart("request") FacilityDto.patch facilityPatch,
                                        @RequestPart(name = "file", required = false) List<MultipartFile> multipartFileList){
        facilityService.patchFacility(facilityId, multipartFileList, facilityPatch);
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }
    //delete facility
    @DeleteMapping("/{facilityId}")
    public ResponseEntity deleteFacility(@PathVariable Long facilityId) {
        facilityService.deleteFacility(facilityId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //get nearFacilityList
    @GetMapping("")
    public ResponseEntity<Slice<ResponseFacilityDto.facilityPageFromCategory>> getNearFacilityList(@RequestParam String location, int page){
        return new ResponseEntity<>(facilityService.getNearFacilityList(location, page), HttpStatus.OK);
    }
}
