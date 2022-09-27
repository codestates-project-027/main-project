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
@DisplayName("patchReview test")
public class ReviewServicePatchTests {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;


    private Review review;

    private Review reviewPatch;

    private ReviewDto.patch reviewDtoPatch;


    @BeforeEach
    public void setup() {
        reviewDtoPatch = new ReviewDto.patch("미니미유저수정", "리뷰내용수정");

        review = new Review(1L, "미니미유저", "리뷰내용",
                LocalDateTime.of(2022, 11, 10, 9 , 14));

        reviewPatch = new Review(1L, "미니미유저수정", "리뷰내용수정",
                LocalDateTime.of(2022, 11, 10, 9 , 14));

    }


    @Nested
    @DisplayName("success case")
    class successCase {
        @Test
        @DisplayName("success test 1 -> all patch")
        public void successTest() throws Exception {
            given(reviewRepository.findById(Mockito.anyLong()))
                    .willReturn(Optional.ofNullable(review));
            given(reviewRepository.save(Mockito.any(Review.class)))
                    .willReturn(reviewPatch);


            reviewService.patchReview(1L,1L,reviewDtoPatch);


            then(reviewRepository).should(times(1))
                    .findById(Mockito.anyLong());
            then(reviewRepository).should(times(1))
                    .save(Mockito.any(Review.class));

        }

        @Test
        @DisplayName("success test 2 -> username patch")
        public void successTest2() throws Exception {
            ReviewDto.patch reviewDtoPatch = ReviewDto.patch.builder()
                    .contents("")
                    .username("asdfid").build();
            given(reviewRepository.findById(Mockito.anyLong()))
                    .willReturn(Optional.ofNullable(review));
            given(reviewRepository.save(Mockito.any(Review.class)))
                    .willReturn(reviewPatch);


            reviewService.patchReview(1L,1L,reviewDtoPatch);


            then(reviewRepository).should(times(1))
                    .findById(Mockito.anyLong());
            then(reviewRepository).should(times(1))
                    .save(Mockito.any(Review.class));

        }
        @Test
        @DisplayName("success test 3 -> username patch")
        public void successTest3() throws Exception {
            ReviewDto.patch reviewDtoPatch = ReviewDto.patch.builder()
                    .username("asdfid").build();
            given(reviewRepository.findById(Mockito.anyLong()))
                    .willReturn(Optional.ofNullable(review));
            given(reviewRepository.save(Mockito.any(Review.class)))
                    .willReturn(reviewPatch);


            reviewService.patchReview(1L,1L,reviewDtoPatch);


            then(reviewRepository).should(times(1))
                    .findById(Mockito.anyLong());
            then(reviewRepository).should(times(1))
                    .save(Mockito.any(Review.class));

        }

        @Test
        @DisplayName("success test 4 -> contents patch")
        public void successTest4() throws Exception {
            ReviewDto.patch reviewDtoPatch = ReviewDto.patch.builder()
                    .contents("asdfid").build();
            given(reviewRepository.findById(Mockito.anyLong()))
                    .willReturn(Optional.ofNullable(review));
            given(reviewRepository.save(Mockito.any(Review.class)))
                    .willReturn(reviewPatch);


            reviewService.patchReview(1L,1L,reviewDtoPatch);


            then(reviewRepository).should(times(1))
                    .findById(Mockito.anyLong());
            then(reviewRepository).should(times(1))
                    .save(Mockito.any(Review.class));

        }
        @Test
        @DisplayName("success test 5 -> contents patch")
        public void successTest5() throws Exception {
            ReviewDto.patch reviewDtoPatch = ReviewDto.patch.builder()
                    .username("")
                    .contents("asdfid").build();
            given(reviewRepository.findById(Mockito.anyLong()))
                    .willReturn(Optional.ofNullable(review));
            given(reviewRepository.save(Mockito.any(Review.class)))
                    .willReturn(reviewPatch);


            reviewService.patchReview(1L,1L,reviewDtoPatch);


            then(reviewRepository).should(times(1))
                    .findById(Mockito.anyLong());
            then(reviewRepository).should(times(1))
                    .save(Mockito.any(Review.class));

        }
    }

    @Nested
    @DisplayName("fail case")
    class failCase {

        @Test
        @DisplayName("fail test 1 -> Not Found Review")
        public void failTest1() throws Exception {
            given(reviewRepository.findById(Mockito.anyLong()))
                    .willThrow(new NullPointerException("Not Found Review"));

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                reviewService.patchReview(1L, 1L, reviewDtoPatch);
            });

            assertThat(exception.getMessage(), equalTo("Not Found Review"));

        }
    }
}
