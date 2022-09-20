package com.minimi.backend.facility.facility.service.facility;


import com.minimi.backend.facility.facility.domain.facility.Facility;
import com.minimi.backend.facility.facility.domain.facility.FacilityDto;
import com.minimi.backend.facility.facility.domain.facility.FacilityRepository;
import com.minimi.backend.facility.facility.mapper.FacilityMapper;
import com.minimi.backend.facility.facility.service.facility.listener.FacilityCategoryCheckListener;
import com.minimi.backend.facility.facility.service.facility.listener.FacilityReviewGetListener;
import com.minimi.backend.facility.review.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;
    private final FacilityCategoryCheckListener facilityCategoryCheckListener;
    private final FacilityReviewGetListener facilityReviewGetListener;
    private final FacilityMapper facilityMapper;


    @Override
    public FacilityDto.response getFacility(Long facilityId) {
        checkFacility(facilityRepository.existsById(facilityId), "Not Found Facility");

        Facility facility = facilityRepository.findById(facilityId)
                .orElseThrow(() -> new RuntimeException("findById Err"));

        FacilityDto.response facilityDtoRes = facilityMapper.facilityToFacilityDtoResponse(facility);
        List<ReviewDto.response> reviewList = facilityReviewGetListener.getReview(facilityId);
        facilityDtoRes.setReviews(reviewList);
        return facilityDtoRes;
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
        checkFacility(facilityRepository.existsById(facilityId), "Not Found Facility");
        facilityRepository.deleteById(facilityId);
    }

    public Boolean checkCategory(List<String> categoryList) {
        categoryList.forEach(categoryCode ->{
            checkFacility(facilityCategoryCheckListener.checkExistsByCategoryCode(categoryCode), "Not Found Category");
        });
        return true;
    }

    public void checkFacility(boolean facilityRepository, String Not_Found_Facility) {
        if (!facilityRepository){
            throw new NullPointerException(Not_Found_Facility);
        }
    }
}
