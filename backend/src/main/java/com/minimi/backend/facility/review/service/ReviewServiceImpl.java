package com.minimi.backend.facility.review.service;


import com.minimi.backend.facility.review.domain.*;
import com.minimi.backend.facility.review.mapper.ReviewMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository  reviewRepository;
    private final ReviewFacilityRepository reviewFacilityRepository;
    private final ReviewMapper reviewMapper;


    @Override
    public List<ReviewDto.response> getReview(Long facilityId) {
        ReviewFacility reviewFacility = reviewFacilityRepository.findByFacilityId(facilityId);

        return reviewMapper.reviewListToReviewDtoResList(reviewFacility.getReview());
    }

    @Override
    public void postReview(ReviewDto.request reviewDtoReq) {
        blankAndNullCheck(reviewDtoReq.getContents());
        blankAndNullCheck(reviewDtoReq.getFacilityId());
        blankAndNullCheck(reviewDtoReq.getUsername());

        checkByFacilityId(!reviewFacilityRepository.existsByFacilityId(reviewDtoReq.getFacilityId()), "Not Found Facility");

        Review review = new Review(reviewDtoReq.getUsername(), reviewDtoReq.getContents());
        Review reviewSave = reviewRepository.save(review);

        ReviewFacility reviewFacility = reviewFacilityRepository
                .findByFacilityId(reviewDtoReq.getFacilityId());
        reviewFacility.addReview(reviewSave);

        reviewFacilityRepository.save(reviewFacility);

    }

    @Override
    public void postReviewFacility(Long facilityId) {
        if (reviewFacilityRepository.existsByFacilityId(facilityId)) {
            throw new RuntimeException();
        }
        reviewFacilityRepository.save(new ReviewFacility(facilityId));
    }

    @Override
    public void deleteReview(Long facilityId, Long reviewId) {
        checkByFacilityId(!reviewFacilityRepository.existsByFacilityId(facilityId), "Not Found Facility");

        Review review = reviewRepository.findById(reviewId).orElseThrow(RuntimeException::new);

        ReviewFacility reviewFacility = reviewFacilityRepository.findByFacilityId(facilityId);

        reviewFacility.removeReview(review);
        reviewFacilityRepository.save(reviewFacility);
        reviewRepository.delete(review);
    }

    private void checkByFacilityId(boolean reviewFacilityRepository, String Not_Found_Facility) {
        if (reviewFacilityRepository){
            throw new NullPointerException(Not_Found_Facility);
        }
    }

    @Override
    public void patchReview(Long facilityId, Long reviewId, ReviewDto.patch reviewDtoPat) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(NullPointerException::new);

        if(!(reviewDtoPat.getContents()==null||reviewDtoPat.getContents().isBlank())) {
            review.setContents(reviewDtoPat.getContents());
        }
        if(!(reviewDtoPat.getUsername()==null||reviewDtoPat.getUsername().isBlank())) {
            review.setUsername(reviewDtoPat.getUsername());
        }

        reviewRepository.save(review);
    }

    public Boolean blankAndNullCheck(Object value) {
        checkByFacilityId(value == null || String.valueOf(value).isBlank(), "Null Value");
        return true;
    }
}
