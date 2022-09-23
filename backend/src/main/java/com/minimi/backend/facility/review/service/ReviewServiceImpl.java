package com.minimi.backend.facility.review.service;


import com.minimi.backend.facility.review.domain.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    @Override
    public Slice<ReviewDto.response> getReviewPage(Long facilityId, int page) {
        return null;
    }
}
