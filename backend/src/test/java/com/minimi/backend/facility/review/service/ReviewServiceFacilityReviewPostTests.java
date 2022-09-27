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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("postReviewFacility test")
public class ReviewServiceFacilityReviewPostTests {
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
                    .willReturn(false);
            given(reviewFacilityRepository.save(Mockito.any(ReviewFacility.class)))
                    .willReturn(reviewFacility);


            reviewService.postReviewFacility(1L);


            then(reviewFacilityRepository).should(times(1))
                    .existsByFacilityId(Mockito.anyLong());
            then(reviewFacilityRepository).should(times(1))
                    .save(Mockito.any(ReviewFacility.class));

        }
    }

    @Nested
    @DisplayName("fail case")
    class failCase {

        @Test
        @DisplayName("fail test 1 -> exists")
        public void failTest1() throws Exception {
            given(reviewFacilityRepository.existsByFacilityId(Mockito.anyLong()))
                    .willReturn(true);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                reviewService.postReviewFacility(1L);
            });

            then(reviewFacilityRepository).should(times(1))
                    .existsByFacilityId(Mockito.anyLong());
            then(reviewFacilityRepository).should(times(0))
                    .save(Mockito.any(ReviewFacility.class));
            assertThat(exception.getMessage(), equalTo("Exists ReviewFacility"));

        }
    }
}

