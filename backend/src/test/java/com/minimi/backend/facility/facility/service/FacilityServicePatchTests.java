package com.minimi.backend.facility.facility.service;


import com.minimi.backend.facility.aws.service.S3UploadService;
import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityRepository;
import com.minimi.backend.facility.facility.domain.FacilityStatus;
import com.minimi.backend.facility.facility.service.listener.FacilityCategoryCheckListener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private S3UploadService s3UploadService;

    @Mock
    private FacilityCategoryCheckListener facilityCategoryCheckListener;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private FacilityServiceImpl facilityService;

    private Facility facility;
    private Facility facilityResult;

    private Facility facilityResult2;
    private Facility facilityResult3;
    private FacilityDto.patch facilityDtoReq;
    private Long facilityId;

    private List<MultipartFile> multipartFileList;

    @BeforeEach
    public void setup () {
        facilityId = 1L;
        facility = new Facility(
                1L,"미니미헬스장",
                new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                "시설정보","서울특별시 강남구","www.website.com",
                "010-0000-0000","34.12345, 119.12345", 4,
                new ArrayList<>(Arrays.asList("헬스", "PT")), FacilityStatus.ACTIVE
        );
        facilityDtoReq = new FacilityDto.patch("미니미헬스장2",
                "시설정보2","서울특별시 강남구2", "www.website.com2",
                "010-0000-0002","34.12345, 119.123452",
                new ArrayList<>(Arrays.asList("헬스", "요가")));
        facilityResult = new Facility(
                1L,"미니미헬스장2",
                new ArrayList<>(Arrays.asList("이미지1", "이미지22")),
                "시설정보2","서울특별시 강남구","www.website.com2",
                "010-0000-0002","34.12345, 119.123452", 4,
                new ArrayList<>(Arrays.asList("헬스", "요가")), FacilityStatus.ACTIVE
        );
        facilityResult2 = new Facility(
                1L,"미니미헬스장2",
                new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                "시설정보2","서울특별시 강남구","www.website.com",
                "010-0000-0000","34.12345, 119.12345", 4,
                new ArrayList<>(Arrays.asList("헬스", "요가")), FacilityStatus.ACTIVE
        );
        facilityResult3 = new Facility(
                1L,"미니미헬스장2",
                new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                "시설정보","서울특별시 강남구","www.website.com",
                "010-0000-0000","34.12345, 119.12345", 4,
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
            given(facilityCategoryCheckListener.checkExistsByCategoryTitle(Mockito.anyString())).willReturn(true);
            given(facilityRepository.save(facility)).willReturn(facilityResult);

            facilityService.patchFacility(facilityId, multipartFileList, facilityDtoReq);

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            then(facilityCategoryCheckListener)
                    .should(times(2)).checkExistsByCategoryTitle(anyString());
            then(facilityRepository).should(times(1)).save(any());
        }
        @Test
        @DisplayName("success patchFacility test 2 -> contain null patch without categoryList")
        public void successPatchFacility2() throws Exception {
            FacilityDto.patch facilityDtoReqContainNull = new FacilityDto.patch();
            facilityDtoReqContainNull.setFacilityName("미니미헬스장2");
            facilityDtoReqContainNull.setFacilityInfo("시설정보2");

            given(facilityRepository.existsById(facilityId)).willReturn(true);
            given(facilityRepository.findById(facilityId)).willReturn(Optional.ofNullable(facility));
            given(facilityRepository.save(facility)).willReturn(Mockito.any(Facility.class));

            facilityService.patchFacility(facilityId,multipartFileList, facilityDtoReqContainNull);

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            then(facilityRepository).should(times(1)).save(any());

        }

        @Test
        @DisplayName("success patchFacility test 3 -> contain null patch with categoryList")
        public void successPatchFacility3() throws Exception {
            FacilityDto.patch facilityDtoReqContainNull = new FacilityDto.patch();
            facilityDtoReqContainNull.setFacilityName("미니미헬스장2");
            facilityDtoReqContainNull.setFacilityInfo("시설정보2");
            facilityDtoReqContainNull.setCategoryList(new ArrayList<>(Arrays.asList("헬스", "요가")));
            given(facilityRepository.existsById(facilityId)).willReturn(true);
            given(facilityRepository.findById(facilityId)).willReturn(Optional.ofNullable(facility));
            given(facilityCategoryCheckListener.checkExistsByCategoryTitle(Mockito.anyString())).willReturn(true);
            given(facilityRepository.save(facility)).willReturn(facilityResult2);

            facilityService.patchFacility(facilityId,multipartFileList, facilityDtoReqContainNull);

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            then(facilityCategoryCheckListener)
                    .should(times(2)).checkExistsByCategoryTitle(anyString());
            then(facilityRepository).should(times(1)).save(any());

        }

        @Test
        @DisplayName("success patchFacility test 4 -> contain blank patch without categoryList")
        public void successPatchFacility4() throws Exception {
            FacilityDto.patch facilityDtoReqContainNull = new FacilityDto.patch();
            facilityDtoReqContainNull.setFacilityName("미니미헬스장2");
            facilityDtoReqContainNull.setFacilityInfo("");
            given(facilityRepository.existsById(facilityId)).willReturn(true);
            given(facilityRepository.findById(facilityId)).willReturn(Optional.ofNullable(facility));
            given(facilityRepository.save(facility)).willReturn(Mockito.any(Facility.class));

            facilityService.patchFacility(facilityId,multipartFileList, facilityDtoReqContainNull);

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            then(facilityRepository).should(times(1)).save(any());

        }
        @Test
        @DisplayName("success patchFacility test 5 -> contain blank patch with categoryList")
        public void successPatchFacility5() throws Exception {
            FacilityDto.patch facilityDtoReqContainNull = new FacilityDto.patch();
            facilityDtoReqContainNull.setFacilityName("미니미헬스장2");
            facilityDtoReqContainNull.setFacilityInfo("");
            facilityDtoReqContainNull.setCategoryList(new ArrayList<>(Arrays.asList("헬스", "요가")));
            given(facilityRepository.existsById(facilityId)).willReturn(true);
            given(facilityRepository.findById(facilityId)).willReturn(Optional.ofNullable(facility));
            given(facilityCategoryCheckListener.checkExistsByCategoryTitle(Mockito.anyString())).willReturn(true);
            given(facilityRepository.save(facility)).willReturn(facilityResult3);

            facilityService.patchFacility(facilityId, multipartFileList, facilityDtoReqContainNull);

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            then(facilityCategoryCheckListener)
                    .should(times(2)).checkExistsByCategoryTitle(anyString());
            then(facilityRepository).should(times(1)).save(any());

        }
        @Test
        @DisplayName("success patchFacility test 6 -> contain blank patch with categoryList size == 0")
        public void successPatchFacility6() throws Exception {
            FacilityDto.patch facilityDtoReqContainNull = new FacilityDto.patch();
            facilityDtoReqContainNull.setFacilityName("미니미헬스장2");
            facilityDtoReqContainNull.setFacilityInfo("");
            facilityDtoReqContainNull.setCategoryList(new ArrayList<>(List.of()));
            given(facilityRepository.existsById(facilityId)).willReturn(true);
            given(facilityRepository.findById(facilityId)).willReturn(Optional.ofNullable(facility));
            given(facilityRepository.save(facility)).willReturn(Mockito.any(Facility.class));

            facilityService.patchFacility(facilityId, multipartFileList, facilityDtoReqContainNull);

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            then(facilityRepository).should(times(1)).save(any());

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
                facilityService.patchFacility(facilityId,multipartFileList, facilityDtoReq);
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
            given(facilityCategoryCheckListener.checkExistsByCategoryTitle(Mockito.anyString())).willReturn(false);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                facilityService.patchFacility(facilityId,multipartFileList, facilityDtoReq);
            });

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            then(facilityCategoryCheckListener)
                    .should(times(1)).checkExistsByCategoryTitle(anyString());
            assertThat(exception.getMessage(), equalTo("Not Found Category"));
        }

        @Test
        @DisplayName("fail patchFacility test 3 -> undefined findById")
        public void failPatchFacility3() throws Exception {
            given(facilityRepository.existsById(facilityId)).willReturn(true);
            given(facilityRepository.findById(facilityId)).willThrow(new NullPointerException("Not Found Facility"));

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                facilityService.patchFacility(facilityId,multipartFileList, facilityDtoReq);
            });

            then(facilityRepository)
                    .should(times(1)).existsById(anyLong());
            then(facilityRepository).should(times(1)).findById(anyLong());
            assertThat(exception.getMessage(), equalTo("Not Found Facility"));
        }
    }
}
