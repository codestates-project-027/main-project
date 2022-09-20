package com.minimi.backend.facility.facility.service.facility;


import com.minimi.backend.facility.facility.domain.facility.Facility;
import com.minimi.backend.facility.facility.domain.facility.FacilityDto;
import com.minimi.backend.facility.facility.domain.facility.FacilityRepository;
import com.minimi.backend.facility.facility.mapper.FacilityMapper;
import com.minimi.backend.facility.facility.service.facility.listener.FacilityCategoryCheckListener;
import com.minimi.backend.facility.facility.service.facility.listener.FacilityReviewGetListener;
import com.minimi.backend.facility.facility.service.facility.publisher.FacilityDeleteEvent;
import com.minimi.backend.facility.facility.service.facility.publisher.FacilityPostEvent;
import com.minimi.backend.facility.review.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;
    private final FacilityCategoryCheckListener facilityCategoryCheckListener;
    private final FacilityReviewGetListener facilityReviewGetListener;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final FacilityMapper facilityMapper;


    @Override
    public FacilityDto.response getFacility(Long facilityId) {
        checkData(facilityRepository.existsById(facilityId), "Not Found Facility");

        Facility facility = checkedFindFacility(facilityId);

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

        Facility facility =facilityRepository.save(Facility.builder()
                .facilityName(facilityDtoReq.getFacilityName())
                .facilityInfo(facilityDtoReq.getFacilityInfo())
                .facilityPhoto(facilityDtoReq.getFacilityPhoto())
                .facilityPhotoList(facilityDtoReq.getFacilityPhotoList())
                .address(facilityDtoReq.getAddress())
                .website(facilityDtoReq.getWebsite())
                .phone(facilityDtoReq.getPhone())
                .location(facilityDtoReq.getLocation())
                .categoryList(facilityDtoReq.getCategoryList())
                .build());

        applicationEventPublisher.publishEvent(new FacilityPostEvent(facility.getFacilityId()));

        return facility;
    }

    @Override
    public Facility patchFacility(Long facilityId ,FacilityDto.patch facilityDtoPat) {
        checkData(facilityRepository.existsById(facilityId), "Not Found Facility");
        Facility facility  = checkedFindFacility(facilityId);


        if(!(facilityDtoPat.getCategoryList()==null||facilityDtoPat.getCategoryList().size()==0)){
            //todo category 검사로직
        }


        Facility patchedFacility = facilityBeanWrapper(facilityDtoPat, facility);

        facilityRepository.save(patchedFacility);
        return patchedFacility;
    }

    @Override
    public void deleteFacility(Long facilityId) {
        checkData(facilityRepository.existsById(facilityId), "Not Found Facility");
        facilityRepository.deleteById(facilityId);
        applicationEventPublisher.publishEvent(new FacilityDeleteEvent(facilityId));
    }

    public Boolean checkCategory(List<String> categoryList) {
        categoryList.forEach(categoryCode ->{
            checkData(facilityCategoryCheckListener.checkExistsByCategoryCode(categoryCode), "Not Found Category");
        });
        return true;
    }

    public Facility checkedFindFacility(Long facilityId) {
        return facilityRepository.findById(facilityId).orElseThrow(NullPointerException::new);
    }

    public void checkData(boolean repositoryExists, String Not_Found_Message) {
        if (!repositoryExists){
            throw new NullPointerException(Not_Found_Message);
        }
    }

    public Facility facilityBeanWrapper(FacilityDto.patch facilityDtoPat, Facility facility) {
        final BeanWrapper patchDataBean = new BeanWrapperImpl(facilityDtoPat);
        final BeanWrapper facilityBean = new BeanWrapperImpl(facility);
        Arrays.stream(facilityDtoPat.getClass().getDeclaredFields()).forEach(field -> {
            Object patchDataField = patchDataBean.getPropertyValue(field.getName());
            if(!(patchDataField==null||patchDataField.toString().isBlank())){
                facilityBean.setPropertyValue(field.getName(),patchDataField);
            }
        });
        return facility;
    }
}
