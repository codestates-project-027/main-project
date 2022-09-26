package com.minimi.backend.facility.review.service;


import com.minimi.backend.facility.review.domain.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository  reviewRepository;
    private final ReviewFacilityRepository reviewFacilityRepository;


    @Override
    public Slice<ReviewDto.response> getReviewPage(Long facilityId, int page) {
        return null;
    }

    @Override
    public void postReview(ReviewDto.request reviewDtoReq) {
        Review review = new Review(reviewDtoReq.getUsername(), reviewDtoReq.getContents());
        Review reviewSave = reviewRepository.save(review);

        ReviewFacility reviewFacility = reviewFacilityRepository
                .findById(reviewDtoReq.getFacilityId()).orElseThrow(RuntimeException::new);
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
        Review review = reviewRepository.findById(reviewId).orElseThrow(RuntimeException::new);
        ReviewFacility reviewFacility = reviewFacilityRepository.findById(facilityId).orElseThrow(RuntimeException::new);

        reviewFacility.removeReview(review);
        reviewFacilityRepository.save(reviewFacility);
        reviewRepository.delete(review);
    }

    @Override
    public void deleteReviewFacility(Long facilityId) {
        if (!reviewFacilityRepository.existsByFacilityId(facilityId)) {
            throw new RuntimeException();
        }
        reviewFacilityRepository.deleteByFacilityId(facilityId);
    }

    @Override
    public void patchReview(Long reviewId, ReviewDto.patch reviewDtoPat) {

    }
}
