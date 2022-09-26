package com.minimi.backend.facility.facility.service;


import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityRepository;
import com.minimi.backend.facility.facility.domain.FacilityStatus;
import com.minimi.backend.facility.facility.mapper.FacilityMapper;
import com.minimi.backend.facility.facility.service.listener.FacilityReviewGetListener;
import com.minimi.backend.facility.review.domain.ReviewDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("getFacility test")
public class FacilityServiceGetTests {
    @Mock
    private FacilityRepository facilityRepository;

    @Mock
    private FacilityReviewGetListener facilityReviewGetListener;

    @Mock
    private FacilityMapper facilityMapper;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private FacilityServiceImpl facilityService;


    private FacilityDto.response facilityDtoRes;
    private FacilityDto.response facilityDtoResResult;
    private Long facilityId;
    private Facility facility;
    private List<ReviewDto.response> reviewDtoResList;

    @BeforeEach
    public void setup() {
        facilityId = 1L;
        facility = new Facility(
                1L, "미니미헬스장", "대표이미지",
                new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                "시설정보", "서울특별시 강남구", "www.web.com",
                "010-0000-0000", "34.12345, 119.12345", 4,
                new ArrayList<>(Arrays.asList("헬스", "PT")), FacilityStatus.ACTIVE
        );

        reviewDtoResList = new ArrayList<>(Arrays.asList(
                new ReviewDto.response(1L, "유저닉네임1",
                        "리뷰내용", LocalDateTime.of(2022, 9, 1,10,20)),
                new ReviewDto.response(2L, "유저닉네임2",
                        "리뷰내용", LocalDateTime.of(2022, 9, 1,10,30))
        ));

        facilityDtoRes = new FacilityDto.response(
                1L, "미니미헬스장",
                new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                "시설정보", "서울시 강남구", "www.web.com",
                "010-0000-0000", 4, "34.12345, 119.12345",
                new ArrayList<>(Arrays.asList("헬스", "PT")),
                FacilityStatus.ACTIVE,
                new ArrayList<>());

        facilityDtoResResult = new FacilityDto.response(
                1L, "미니미헬스장",
                new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                "시설정보", "서울시 강남구", "www.web.com",
                "010-0000-0000", 4, "34.12345, 119.12345",
                new ArrayList<>(Arrays.asList("헬스", "PT")),
                FacilityStatus.ACTIVE,
                new ArrayList<>(Arrays.asList(
                        new ReviewDto.response(1L, "유저닉네임1",
                                "리뷰내용", LocalDateTime.of(2022, 9, 1,10,20)),
                        new ReviewDto.response(2L, "유저닉네임2",
                                "리뷰내용", LocalDateTime.of(2022, 9, 1,10,30))
                ))
        );

    }

        @Nested
        @DisplayName("success getFacility case")
        class successGetFacilityCase {

            @Test
            @DisplayName("success getFacility test 1 -> get")
            public void successFacility() throws Exception {
                given(facilityRepository.existsById(facilityId)).willReturn(true);
                given(facilityRepository.findById(facilityId)).willReturn(Optional.ofNullable(facility));
                given(facilityReviewGetListener.getReview(facilityId)).willReturn(reviewDtoResList);
                given(facilityMapper.facilityToFacilityDtoResponse(facility)).willReturn(facilityDtoRes);

                FacilityDto.response result = facilityService.getFacility(facilityId);

                assertThat(result.getFacilityId(), equalTo(facilityDtoResResult.getFacilityId()));
                assertThat(result.getWebsite(), equalTo(facilityDtoResResult.getWebsite()));
                assertThat(result.getPhone(), equalTo(facilityDtoResResult.getPhone()));
                assertThat(result.getLocation(), equalTo(facilityDtoResResult.getLocation()));
                assertThat(result.getFacilityName(), equalTo(facilityDtoResResult.getFacilityName()));
                assertThat(result.getFacilityInfo(), equalTo(facilityDtoResResult.getFacilityInfo()));
                assertThat(result.getFacilityPhotoList(), equalTo(facilityDtoResResult.getFacilityPhotoList()));
                assertThat(result.getAddress(), equalTo(facilityDtoResResult.getAddress()));
                assertThat(result.getStarRate(), equalTo(facilityDtoResResult.getStarRate()));
                assertThat(result.getFacilityStatus(), equalTo(facilityDtoResResult.getFacilityStatus()));
                assertThat(result.getCategoryList(), equalTo(facilityDtoResResult.getCategoryList()));
                assertThat(result.getReviews().get(0).getReviewId(), equalTo(facilityDtoResResult.getReviews().get(0).getReviewId()));
                assertThat(result.getReviews().get(0).getContents(), equalTo(facilityDtoResResult.getReviews().get(0).getContents()));
                assertThat(result.getReviews().get(0).getUsername(), equalTo(facilityDtoResResult.getReviews().get(0).getUsername()));
                assertThat(result.getReviews().get(1).getReviewId(), equalTo(facilityDtoResResult.getReviews().get(1).getReviewId()));
                assertThat(result.getReviews().get(1).getContents(), equalTo(facilityDtoResResult.getReviews().get(1).getContents()));
                assertThat(result.getReviews().get(1).getUsername(), equalTo(facilityDtoResResult.getReviews().get(1).getUsername()));
        }
    }
}
