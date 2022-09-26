package com.minimi.backend.facility.review.service;


import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.review.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("postReview test")
public class ReviewServicePostTests {


    @Mock
    private ReviewFacilityRepository reviewFacilityRepository;

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;


    private Review review;

    private ReviewFacility reviewFacility;

    private ReviewFacility reviewFacilityWithReview;

    private ReviewDto.request reviewDtoReq;


    @BeforeEach
    public void setup() {
        reviewDtoReq = new ReviewDto.request(1L, "미니미유저", "리뷰내용");

        review = new Review(1L, "미니미유저", "리뷰내용",
                LocalDateTime.of(2022, 11, 10, 9 , 14));

        reviewFacility = new ReviewFacility(1L, 1L, new ArrayList<>());

        reviewFacilityWithReview = new ReviewFacility(1L, 1L, new ArrayList<>(List.of(review)));
    }


    @Nested
    @DisplayName("success case")
    class successCase {
        @Test
        @DisplayName("success test 1 -> create")
        public void successTest() throws Exception {
            given(reviewFacilityRepository.existsByFacilityId(Mockito.anyLong()))
                    .willReturn(true);
            given(reviewRepository.save(Mockito.any(Review.class)))
                    .willReturn(review);
            given(reviewFacilityRepository.findByFacilityId(Mockito.anyLong()))
                    .willReturn(reviewFacility);
            given(reviewFacilityRepository.save(Mockito.any(ReviewFacility.class)))
                    .willReturn(reviewFacilityWithReview);


            reviewService.postReview(reviewDtoReq);


            then(reviewFacilityRepository).should(times(1))
                    .existsByFacilityId(Mockito.anyLong());
            then(reviewRepository).should(times(1))
                    .save(Mockito.any(Review.class));
            then(reviewFacilityRepository).should(times(1))
                    .findByFacilityId(Mockito.anyLong());
            then(reviewFacilityRepository).should(times(1))
                    .save(Mockito.any(ReviewFacility.class));

        }
    }
}
