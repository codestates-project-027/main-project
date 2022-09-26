package com.minimi.backend.facility.review.service;


import com.minimi.backend.facility.review.domain.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("deleteReview test")
public class ReviewServiceDeleteTests {

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
        @DisplayName("success test 1 -> delete")
        public void successTest() throws Exception {
            given(reviewFacilityRepository.existsByFacilityId(Mockito.anyLong())).willReturn(true);
            given(reviewRepository.findById(Mockito.anyLong()))
                    .willReturn(Optional.ofNullable(review));
            given(reviewFacilityRepository.findByFacilityId(Mockito.anyLong()))
                    .willReturn(reviewFacilityWithReview);
            given(reviewFacilityRepository.save(Mockito.any(ReviewFacility.class)))
                    .willReturn(reviewFacility);


            reviewService.deleteReview(1L, 1L);


            then(reviewFacilityRepository).should(times(1))
                    .existsByFacilityId(Mockito.anyLong());
            then(reviewRepository).should(times(1))
                    .findById(Mockito.anyLong());
            then(reviewFacilityRepository).should(times(1))
                    .findByFacilityId(Mockito.anyLong());
            then(reviewFacilityRepository).should(times(1))
                    .save(Mockito.any(ReviewFacility.class));
            then(reviewRepository).should(times(1))
                    .delete(Mockito.any(Review.class));

        }
    }

    @Nested
    @DisplayName("fail case")
    class failCase {
        @Test
        @DisplayName("fail test 1 -> not found facilityId")
        public void failTest() throws Exception {
            given(reviewFacilityRepository.existsByFacilityId(Mockito.anyLong())).willReturn(false);


            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                        reviewService.deleteReview(1L, 1L);
                    });

            then(reviewFacilityRepository).should(times(1))
                    .existsByFacilityId(Mockito.anyLong());
            then(reviewRepository).should(times(0))
                    .findById(Mockito.anyLong());
            then(reviewFacilityRepository).should(times(0))
                    .findByFacilityId(Mockito.anyLong());
            then(reviewFacilityRepository).should(times(0))
                    .save(Mockito.any(ReviewFacility.class));
            then(reviewRepository).should(times(0))
                    .delete(Mockito.any(Review.class));

            assertThat(exception.getMessage(), equalTo("Not Found Facility"));
        }

        @Test
        @DisplayName("fail test 2 -> not found reviewId")
        public void failTest2() throws Exception {
            given(reviewFacilityRepository.existsByFacilityId(Mockito.anyLong())).willReturn(true);
            given(reviewRepository.findById(Mockito.anyLong()))
                    .willThrow(new NullPointerException("Not Found Facility"));


            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                reviewService.deleteReview(1L, 1L);
            });

            then(reviewFacilityRepository).should(times(1))
                    .existsByFacilityId(Mockito.anyLong());
            then(reviewRepository).should(times(1))
                    .findById(Mockito.anyLong());
            then(reviewFacilityRepository).should(times(0))
                    .findByFacilityId(Mockito.anyLong());
            then(reviewFacilityRepository).should(times(0))
                    .save(Mockito.any(ReviewFacility.class));
            then(reviewRepository).should(times(0))
                    .delete(Mockito.any(Review.class));

            assertThat(exception.getMessage(), equalTo("Not Found Facility"));
        }
    }

}
