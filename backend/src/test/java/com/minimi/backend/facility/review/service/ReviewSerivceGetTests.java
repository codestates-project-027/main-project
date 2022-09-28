package com.minimi.backend.facility.review.service;


import com.minimi.backend.facility.review.domain.*;
import com.minimi.backend.facility.review.mapper.ReviewMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("getReview test")
public class ReviewSerivceGetTests {

    @Mock
    private ReviewFacilityRepository reviewFacilityRepository;

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ReviewMapper reviewMapper;

    @InjectMocks
    private ReviewServiceImpl reviewService;



    private Review review;

    private ReviewFacility reviewFacility;

    private ReviewFacility reviewFacilityWithReview;

    private ReviewDto.request reviewDtoReq;

    private List<ReviewDto.response> reviewDtoResList;


    @BeforeEach
    public void setup() {
        reviewDtoReq = new ReviewDto.request(1L, "미니미유저", "리뷰내용");

        review = new Review(1L, "미니미유저", "리뷰내용",
                LocalDateTime.of(2022, 11, 10, 9 , 14));

        reviewFacility = new ReviewFacility(1L, 1L, new ArrayList<>());

        reviewFacilityWithReview = new ReviewFacility(1L, 1L, new ArrayList<>(List.of(review)));

        reviewDtoResList = new ArrayList<>(Arrays.asList(
                new ReviewDto.response(1L,"abc","eff",LocalDateTime.of(2022, 11, 10, 9 , 14)),
                new ReviewDto.response(2L,"abec","efs",LocalDateTime.of(2022, 11, 10, 10 , 14))
        ));

    }


    @Nested
    @DisplayName("success case")
    class successCase {
        @Test
        @DisplayName("success test 1 -> get review")
        public void successTest() throws Exception {
            given(reviewFacilityRepository.existsByFacilityId(Mockito.anyLong()))
                    .willReturn(true);
            given(reviewFacilityRepository.findByFacilityId(Mockito.anyLong()))
                    .willReturn(reviewFacilityWithReview);
            given(reviewMapper.reviewListToReviewDtoResList(Mockito.anyList()))
                    .willReturn(reviewDtoResList);

            reviewService.getReview(1L);

            then(reviewFacilityRepository).should(times(1))
                    .existsByFacilityId(Mockito.anyLong());
            then(reviewFacilityRepository).should(times(1))
                    .findByFacilityId(Mockito.anyLong());
            then(reviewMapper).should(times(1))
                    .reviewListToReviewDtoResList(Mockito.anyList());

        }
    }
    @Nested
    @DisplayName("fail case")
    class failcase {
        @Test
        @DisplayName("fail test 1 -> not found facility")
        public void successTest() throws Exception {
            given(reviewFacilityRepository.existsByFacilityId(Mockito.anyLong()))
                    .willReturn(false);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                        reviewService.getReview(1L);
                    });

            then(reviewFacilityRepository).should(times(1))
                    .existsByFacilityId(Mockito.anyLong());
            then(reviewFacilityRepository).should(times(0))
                    .findByFacilityId(Mockito.anyLong());
            then(reviewMapper).should(times(0))
                    .reviewListToReviewDtoResList(Mockito.anyList());

            assertThat(exception.getMessage(), equalTo("Not Found Facility"));
        }
    }

}
