package com.minimi.backend.facility.facility.service;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import org.springframework.data.domain.Slice;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FacilityService {
    public FacilityDto.response getFacility(Long facilityId);

    public Slice<ResponseFacilityDto.facilityPageFromCategory> getNearFacilityList(String location, int page);

    public Slice<ResponseFacilityDto.facilityPageFromCategory> getCategoryFacility(String categoryCode, int page);

    public void postFacility(List<MultipartFile> multipartFileList, FacilityDto.request facilityDtoReq);

    public void patchFacility(Long facilityId,List<MultipartFile> multipartFileList, FacilityDto.patch facilityDtoPat);

    public void deleteFacility(Long facilityId);


}
