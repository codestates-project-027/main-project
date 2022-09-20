package com.minimi.backend.facility.facility.service;


import com.minimi.backend.facility.facility.domain.facility.Facility;
import com.minimi.backend.facility.facility.domain.facility.FacilityDto;
import com.minimi.backend.facility.facility.domain.facilitycategory.FacilityCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService{
    @Override
    public FacilityDto.response getFacility(Long facilityId) {
        return null;
    }

    @Override
    public Slice<FacilityDto.responsePage> getNearFacilityList(String location, int page) {
        return null;
    }

    @Override
    public Slice<FacilityDto.responsePage> getCategoryFacility(String categoryTitle, int page) {
        return null;
    }

    @Override
    public Facility postFacility(FacilityDto.request facilityDtoReq) {
        return null;
    }

    @Override
    public Facility patchFacility(FacilityDto.patch facilityDtoPat) {
        return null;
    }

    @Override
    public void deleteFacility(Long facilityId) {

    }
}
