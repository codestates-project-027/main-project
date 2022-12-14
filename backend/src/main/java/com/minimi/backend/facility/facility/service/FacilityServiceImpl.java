package com.minimi.backend.facility.facility.service;


import com.minimi.backend.facility.aws.service.S3UploadService;
import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityRepository;
import com.minimi.backend.facility.facility.domain.FacilityStatus;
import com.minimi.backend.facility.facility.mapper.FacilityMapper;
import com.minimi.backend.facility.facility.service.listener.FacilityCategoryCheckListener;
import com.minimi.backend.facility.facility.service.listener.FacaMappingGetListener;
import com.minimi.backend.facility.facility.service.listener.FacilityReviewGetListener;
import com.minimi.backend.facility.facility.service.pub.FacilityDeleteEvent;
import com.minimi.backend.facility.facility.service.pub.FacilityPostEvent;
import com.minimi.backend.facility.facility.service.pub.FacilityPostReviewEvent;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.review.domain.ReviewDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;
    private final FacilityCategoryCheckListener facilityCategoryCheckListener;
    private final FacilityReviewGetListener facilityReviewGetListener;
    private final FacaMappingGetListener facaMappingGetListener;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final FacilityMapper facilityMapper;

    private final S3UploadService s3UploadService;


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

        Slice<Facility> facilitySlice = facilityRepository.findByFacilityStatus(FacilityStatus.PENDING,
                PageRequest.of(page-1,30, Sort.by("facilityId").descending()));

        List<FacilityDto.responsePage> responsePageContents = new ArrayList<>();
        facilitySlice.getContent().forEach(facility ->{
            FacilityDto.responsePage reqDto = facilityMapper.facilityToFacilityDtoResPage(facility);

            if (!facility.getFacilityPhotoList().isEmpty()){
                reqDto.setFacilityPhoto(facility.getFacilityPhotoList().get(0));
            }

            responsePageContents.add(reqDto);
        });
        return new SliceImpl<>(responsePageContents,facilitySlice.getPageable(),facilitySlice.hasNext());
    }

    @Override
    public Slice<ResponseFacilityDto.facilityPageFromCategory> getCategoryFacility(String categoryCode, int page) {
        return facaMappingGetListener.getFacilityFromCategory(categoryCode, page);
    }

    @SneakyThrows
    @Override
    public void postFacility(List<MultipartFile> multipartFileList, FacilityDto.request facilityDtoReq) {

        List<String> imageList = new ArrayList<>();


        if (multipartFileList != null && !multipartFileList.get(0).isEmpty()) {
            imageList = s3UploadService.upload(multipartFileList);
        }

        facilityDtoReq.setCategoryList(
                facilityDtoReq.getCategoryList().stream().distinct().collect(Collectors.toList()));
        checkCategory(facilityDtoReq.getCategoryList());

        Facility facility =facilityRepository.save(Facility.builder()
                .facilityName(facilityDtoReq.getFacilityName())
                .facilityInfo(facilityDtoReq.getFacilityInfo())
                .facilityPhotoList(imageList)
                .address(facilityDtoReq.getAddress())
                .website(facilityDtoReq.getWebsite())
                .phone(facilityDtoReq.getPhone())
                .location(facilityDtoReq.getLocation())
                .categoryList(facilityDtoReq.getCategoryList())
                .build());

        applicationEventPublisher.publishEvent(new FacilityPostReviewEvent(facility.getFacilityId()));
        publishPostEventList(facility);
    }

    @SneakyThrows
    @Override
    @Transactional
    public void patchFacility(Long facilityId, List<MultipartFile> multipartFileList, FacilityDto.patch facilityDtoPat) {

        checkData(facilityRepository.existsById(facilityId), "Not Found Facility");
        Facility facility  = checkedFindFacility(facilityId);


        if (multipartFileList != null && !multipartFileList.get(0).isEmpty()) {
            List<String> imageList = new ArrayList<>();
            imageList = s3UploadService.upload(multipartFileList);
            facility.setFacilityPhotoList(imageList);
        }


        if((facilityDtoPat.getCategoryList()==null||facilityDtoPat.getCategoryList().size()==0)) {
            Facility patchedFacility = facilityBeanWrapper(facilityDtoPat, facility);

            facilityRepository.save(patchedFacility);
            return;
        }

        facilityDtoPat.setCategoryList(
                facilityDtoPat.getCategoryList().stream().distinct().collect(Collectors.toList()));
        checkCategory(facilityDtoPat.getCategoryList());

        Facility patchedFacility = facilityBeanWrapper(facilityDtoPat, facility);

        Facility resultFacility = facilityRepository.save(patchedFacility);

        applicationEventPublisher.publishEvent(new FacilityDeleteEvent(facilityId));
        publishPostEventList(resultFacility);
    }

    @Override
    @Transactional
    public void deleteFacility(Long facilityId) {
        checkData(facilityRepository.existsById(facilityId), "Not Found Facility");
        applicationEventPublisher.publishEvent(new FacilityDeleteEvent(facilityId));
        
        facilityRepository.deleteById(facilityId);
    }

    public Boolean checkCategory(List<String> categoryList) {
        categoryList.forEach(categoryTitle ->{
            checkData(facilityCategoryCheckListener.checkExistsByCategoryTitle(categoryTitle), "Not Found Category");
        });
        return true;
    }

    public Facility checkedFindFacility(Long facilityId) {
        return facilityRepository.findById(facilityId).orElseThrow(() -> new NullPointerException("Not Found Facility"));
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

    public void publishPostEventList(Facility facility) {
        facility.getCategoryList().forEach(categoryTitle -> {
            FacilityCategory facilityCategory = facilityCategoryCheckListener.getFacilityCategoryByTitle(categoryTitle);
            applicationEventPublisher.publishEvent(
                    new FacilityPostEvent(facilityCategory, facility));
        });
    }
}
