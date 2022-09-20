package com.minimi.backend.facility.facility.service;


import com.minimi.backend.facility.facility.domain.facility.Facility;
import com.minimi.backend.facility.facility.domain.facility.FacilityDto;
import com.minimi.backend.facility.facility.domain.facility.FacilityRepository;
import com.minimi.backend.facility.facility.domain.facility.FacilityStatus;
import com.minimi.backend.facility.facility.service.facility.FacilityServiceImpl;
import com.minimi.backend.facility.facility.service.facility.listener.FacilityCategoryCheckListener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("patchFacility test")
public class FacilityServicePatchTests {
    @Mock
    private FacilityRepository facilityRepository;

    @Mock
    private FacilityCategoryCheckListener facilityCategoryCheckListener;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private FacilityServiceImpl facilityService;

    private Facility facility;
    private Facility facilityResult;
    private FacilityDto.patch facilityDtoReq;
    private Long facilityId;

    @BeforeEach
    public void setup () {
        facilityId = 1L;
        facility = new Facility(
                1L,"미니미헬스장","대표이미지",
                new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                "시설정보","서울특별시 강남구","www.website.com",
                "010-0000-0000","34.12345, 119.12345", 4,
                new ArrayList<>(Arrays.asList("헬스", "PT")), FacilityStatus.ACTIVE
        );
        facilityDtoReq = new FacilityDto.patch("미니미헬스장2","대표이미지2",
                new ArrayList<>(Arrays.asList("이미지1", "이미지22")),
                "시설정보2","서울특별시 강남구2", "www.website.com2",
                "010-0000-0002","34.12345, 119.123452",
                new ArrayList<>(Arrays.asList("헬스", "요가")));
        facilityResult = new Facility(
                1L,"미니미헬스장2","대표이미지2",
                new ArrayList<>(Arrays.asList("이미지1", "이미지22")),
                "시설정보2","서울특별시 강남구2","www.website.com2",
                "010-0000-0002","34.12345, 119.123452", 4,
                new ArrayList<>(Arrays.asList("헬스", "요가")), FacilityStatus.ACTIVE
        );
    }

    @Nested
    @DisplayName("success patchFacility case")
    class successPatchFacilityCase {
        @Test
        @DisplayName("success patchFacility test 1 -> allPatch")
        public void successPatchFacility() throws Exception {
            given(facilityRepository.existsById(facilityId)).willReturn(true);
            given(facilityRepository.findById(facilityId)).willReturn(Optional.ofNullable(facility));
            given(facilityCategoryCheckListener.checkExistsByCategoryCode(Mockito.anyString())).willReturn(true);
            given(facilityRepository.save(facility)).willReturn(facilityResult);

            Facility result = facilityService.patchFacility(facilityId, facilityDtoReq);

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            then(facilityCategoryCheckListener)
                    .should(times(2)).checkExistsByCategoryCode(anyString());
            then(facilityRepository).should(times(1)).save(any());
            assertThat(result.getPhone(), equalTo(facilityResult.getPhone()));
            assertThat(result.getFacilityId(), equalTo(facilityResult.getFacilityId()));
            assertThat(result.getFacilityInfo(), equalTo(facilityResult.getFacilityInfo()));
            assertThat(result.getFacilityName(), equalTo(facilityResult.getFacilityName()));
            assertThat(result.getAddress(), equalTo(facilityResult.getAddress()));
            assertThat(result.getFacilityPhoto(), equalTo(facilityResult.getFacilityPhoto()));
            assertThat(result.getLocation(), equalTo(facilityResult.getLocation()));
            assertThat(result.getStarRate(), equalTo(facilityResult.getStarRate()));
            assertThat(result.getWebsite(), equalTo(facilityResult.getWebsite()));
            assertThat(result.getFacilityPhotoList(), equalTo(facilityResult.getFacilityPhotoList()));
            assertThat(result.getFacilityStatus(), equalTo(facilityResult.getFacilityStatus()));
            assertThat(result.getCategoryList(), equalTo(facilityResult.getCategoryList()));
        }
        @Test
        @DisplayName("success patchFacility test 2 -> contain null patch without categoryList")
        public void successPatchFacility2() throws Exception {
            FacilityDto.patch facilityDtoReqContainNull = new FacilityDto.patch();
            facilityDtoReqContainNull.setFacilityName("미니미헬스장2");
            facilityDtoReqContainNull.setFacilityPhoto("이미지22");
            facilityDtoReqContainNull.setFacilityInfo("시설정보2");
            facilityDtoReqContainNull.setFacilityPhotoList(new ArrayList<>(Arrays.asList("이미지1", "이미지22")));
            given(facilityRepository.existsById(facilityId)).willReturn(true);
            given(facilityRepository.findById(facilityId)).willReturn(Optional.ofNullable(facility));
            given(facilityRepository.save(facility)).willReturn(Mockito.any(Facility.class));

            Facility result = facilityService.patchFacility(facilityId, facilityDtoReqContainNull);

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            then(facilityRepository).should(times(1)).save(any());
            assertThat(result.getPhone(), equalTo(facility.getPhone()));
            assertThat(result.getFacilityId(), equalTo(facilityResult.getFacilityId()));
            assertThat(result.getFacilityInfo(), equalTo(facilityResult.getFacilityInfo()));
            assertThat(result.getFacilityName(), equalTo(facilityResult.getFacilityName()));
            assertThat(result.getAddress(), equalTo(facility.getAddress()));
            assertThat(result.getFacilityPhoto(), equalTo(facility.getFacilityPhoto()));
            assertThat(result.getLocation(), equalTo(facility.getLocation()));
            assertThat(result.getStarRate(), equalTo(facilityResult.getStarRate()));
            assertThat(result.getWebsite(), equalTo(facility.getWebsite()));
            assertThat(result.getFacilityPhotoList(), equalTo(facilityResult.getFacilityPhotoList()));
            assertThat(result.getFacilityStatus(), equalTo(facilityResult.getFacilityStatus()));
            assertThat(result.getCategoryList(), equalTo(facility.getCategoryList()));
        }

        @Test
        @DisplayName("success patchFacility test 3 -> contain null patch with categoryList")
        public void successPatchFacility3() throws Exception {
            FacilityDto.patch facilityDtoReqContainNull = new FacilityDto.patch();
            facilityDtoReqContainNull.setFacilityName("미니미헬스장2");
            facilityDtoReqContainNull.setFacilityPhoto("이미지22");
            facilityDtoReqContainNull.setFacilityInfo("시설정보2");
            facilityDtoReqContainNull.setCategoryList(new ArrayList<>(Arrays.asList("헬스", "요가")));
            given(facilityRepository.existsById(facilityId)).willReturn(true);
            given(facilityRepository.findById(facilityId)).willReturn(Optional.ofNullable(facility));
            given(facilityCategoryCheckListener.checkExistsByCategoryCode(Mockito.anyString())).willReturn(true);
            given(facilityRepository.save(facility)).willReturn(Mockito.any(Facility.class));

            Facility result = facilityService.patchFacility(facilityId, facilityDtoReqContainNull);

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            then(facilityCategoryCheckListener)
                    .should(times(2)).checkExistsByCategoryCode(anyString());
            then(facilityRepository).should(times(1)).save(any());
            assertThat(result.getPhone(), equalTo(facility.getPhone()));
            assertThat(result.getFacilityId(), equalTo(facilityResult.getFacilityId()));
            assertThat(result.getFacilityInfo(), equalTo(facilityResult.getFacilityInfo()));
            assertThat(result.getFacilityName(), equalTo(facilityResult.getFacilityName()));
            assertThat(result.getAddress(), equalTo(facility.getAddress()));
            assertThat(result.getFacilityPhoto(), equalTo(facility.getFacilityPhoto()));
            assertThat(result.getLocation(), equalTo(facility.getLocation()));
            assertThat(result.getStarRate(), equalTo(facilityResult.getStarRate()));
            assertThat(result.getWebsite(), equalTo(facility.getWebsite()));
            assertThat(result.getFacilityPhotoList(), equalTo(facility.getFacilityPhotoList()));
            assertThat(result.getFacilityStatus(), equalTo(facilityResult.getFacilityStatus()));
            assertThat(result.getCategoryList(), equalTo(facilityResult.getCategoryList()));
        }

        @Test
        @DisplayName("success patchFacility test 4 -> contain blank patch without categoryList")
        public void successPatchFacility4() throws Exception {
            FacilityDto.patch facilityDtoReqContainNull = new FacilityDto.patch();
            facilityDtoReqContainNull.setFacilityName("미니미헬스장2");
            facilityDtoReqContainNull.setFacilityPhoto("이미지22");
            facilityDtoReqContainNull.setFacilityInfo("");
            facilityDtoReqContainNull.setFacilityPhotoList(new ArrayList<>(Arrays.asList("이미지1", "이미지22")));
            given(facilityRepository.existsById(facilityId)).willReturn(true);
            given(facilityRepository.findById(facilityId)).willReturn(Optional.ofNullable(facility));
            given(facilityRepository.save(facility)).willReturn(Mockito.any(Facility.class));

            Facility result = facilityService.patchFacility(facilityId, facilityDtoReqContainNull);

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            then(facilityRepository).should(times(1)).save(any());
            assertThat(result.getPhone(), equalTo(facility.getPhone()));
            assertThat(result.getFacilityId(), equalTo(facilityResult.getFacilityId()));
            assertThat(result.getFacilityInfo(), equalTo(facility.getFacilityInfo()));
            assertThat(result.getFacilityName(), equalTo(facilityResult.getFacilityName()));
            assertThat(result.getAddress(), equalTo(facility.getAddress()));
            assertThat(result.getFacilityPhoto(), equalTo(facility.getFacilityPhoto()));
            assertThat(result.getLocation(), equalTo(facility.getLocation()));
            assertThat(result.getStarRate(), equalTo(facilityResult.getStarRate()));
            assertThat(result.getWebsite(), equalTo(facility.getWebsite()));
            assertThat(result.getFacilityPhotoList(), equalTo(facilityResult.getFacilityPhotoList()));
            assertThat(result.getFacilityStatus(), equalTo(facilityResult.getFacilityStatus()));
            assertThat(result.getCategoryList(), equalTo(facility.getCategoryList()));
        }
        @Test
        @DisplayName("success patchFacility test 5 -> contain blank patch with categoryList")
        public void successPatchFacility5() throws Exception {
            FacilityDto.patch facilityDtoReqContainNull = new FacilityDto.patch();
            facilityDtoReqContainNull.setFacilityName("미니미헬스장2");
            facilityDtoReqContainNull.setFacilityPhoto("이미지22");
            facilityDtoReqContainNull.setFacilityInfo("");
            facilityDtoReqContainNull.setCategoryList(new ArrayList<>(Arrays.asList("헬스", "요가")));
            given(facilityRepository.existsById(facilityId)).willReturn(true);
            given(facilityRepository.findById(facilityId)).willReturn(Optional.ofNullable(facility));
            given(facilityCategoryCheckListener.checkExistsByCategoryCode(Mockito.anyString())).willReturn(true);
            given(facilityRepository.save(facility)).willReturn(Mockito.any(Facility.class));

            Facility result = facilityService.patchFacility(facilityId, facilityDtoReqContainNull);

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            then(facilityCategoryCheckListener)
                    .should(times(2)).checkExistsByCategoryCode(anyString());
            then(facilityRepository).should(times(1)).save(any());
            assertThat(result.getPhone(), equalTo(facility.getPhone()));
            assertThat(result.getFacilityId(), equalTo(facilityResult.getFacilityId()));
            assertThat(result.getFacilityInfo(), equalTo(facility.getFacilityInfo()));
            assertThat(result.getFacilityName(), equalTo(facilityResult.getFacilityName()));
            assertThat(result.getAddress(), equalTo(facility.getAddress()));
            assertThat(result.getFacilityPhoto(), equalTo(facility.getFacilityPhoto()));
            assertThat(result.getLocation(), equalTo(facility.getLocation()));
            assertThat(result.getStarRate(), equalTo(facilityResult.getStarRate()));
            assertThat(result.getWebsite(), equalTo(facility.getWebsite()));
            assertThat(result.getFacilityPhotoList(), equalTo(facility.getFacilityPhotoList()));
            assertThat(result.getFacilityStatus(), equalTo(facilityResult.getFacilityStatus()));
            assertThat(result.getCategoryList(), equalTo(facilityResult.getCategoryList()));
        }
    }


    @Nested
    @DisplayName("fail patchFacility case")
    class failPatchFacilityCase {
        @Test
        @DisplayName("fail patchFacility test 1 -> notExists")
        public void failPatchFacility() throws Exception {
            given(facilityRepository.existsById(facilityId)).willReturn(false);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                facilityService.patchFacility(facilityId, facilityDtoReq);
            });

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            assertThat(exception.getMessage(), equalTo("Not Found Facility"));
        }

        @Test
        @DisplayName("fail patchFacility test 2 -> notFoundCategory")
        public void failPatchFacility2() throws Exception {
            given(facilityRepository.existsById(facilityId)).willReturn(true);
            given(facilityRepository.findById(facilityId)).willReturn(Optional.ofNullable(facility));
            given(facilityCategoryCheckListener.checkExistsByCategoryCode(Mockito.anyString())).willReturn(false);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                facilityService.patchFacility(facilityId, facilityDtoReq);
            });

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            then(facilityCategoryCheckListener)
                    .should(times(1)).checkExistsByCategoryCode(anyString());
            assertThat(exception.getMessage(), equalTo("Not Found Category"));
        }

        @Test
        @DisplayName("fail patchFacility test 3 -> undefined findById")
        public void failPatchFacility3() throws Exception {
            given(facilityRepository.existsById(facilityId)).willReturn(true);
            given(facilityRepository.findById(facilityId)).willThrow(new NullPointerException("Not Found Facility"));

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                facilityService.patchFacility(facilityId, facilityDtoReq);
            });

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            assertThat(exception.getMessage(), equalTo("Not Found Facility"));
        }
    }
}
