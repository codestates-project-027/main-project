package com.minimi.backend.facility.facility.service.facility;


import com.minimi.backend.facility.facility.domain.facility.Facility;
import com.minimi.backend.facility.facility.domain.facility.FacilityDto;
import com.minimi.backend.facility.facility.domain.facility.FacilityRepository;
import com.minimi.backend.facility.facility.service.facility.listener.FacilityCategoryCheckListener;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;
    private final FacilityCategoryCheckListener facilityCategoryCheckListener;


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

        checkCategory(facilityDtoReq.getCategoryList());

        Facility facility = Facility.builder()
                .facilityName(facilityDtoReq.getFacilityName())
                .facilityInfo(facilityDtoReq.getFacilityInfo())
                .facilityPhoto(facilityDtoReq.getFacilityPhoto())
                .facilityPhotoList(facilityDtoReq.getFacilityPhotoList())
                .address(facilityDtoReq.getAddress())
                .website(facilityDtoReq.getWebsite())
                .phone(facilityDtoReq.getPhone())
                .location(facilityDtoReq.getLocation())
                .categoryList(facilityDtoReq.getCategoryList())
                .build();
        return facilityRepository.save(facility);
    }

    @Override
    public Facility patchFacility(FacilityDto.patch facilityDtoPat) {
        return null;
    }

    @Override
    public void deleteFacility(Long facilityId) {

    }

    public Boolean checkCategory(List<String> categoryList) {
        categoryList.forEach(categoryCode ->{
            if (!facilityCategoryCheckListener.checkExistsByCategoryCode(categoryCode)) {
                throw new NullPointerException("Not Found Category");
            }
        });
        return true;
    }
}
