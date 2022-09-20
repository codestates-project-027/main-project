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
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("postFacility test")
public class FacilityServiceDeleteTests {

    @Mock
    private FacilityRepository facilityRepository;

    @Mock
    private FacilityCategoryCheckListener facilityCategoryCheckListener;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private FacilityServiceImpl facilityService;

    private Facility facility;
    private Long facilityId;

    @BeforeEach
    public void setup () {
        facilityId = 1L;
        facility = new Facility(
                1L,"미니미헬스장","대표이미지",
                new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                "시설정보","서울특별시 강남구","www.website.com",
                "010-0000-0000","34.12345, 119.12345", 4,
                new ArrayList<>(Arrays.asList("헬스", "PT")), FacilityStatus.PENDING
        );
    }

    @Nested
    @DisplayName("success deleteFacility case")
    class successDeleteFacilityCase {
        @Test
        @DisplayName("success DeleteFacility test 1 -> delete")
        public void successDeleteFacility() throws Exception {
            given(facilityRepository.existsById(Mockito.anyLong())).willReturn(true);
            given(facilityRepository.findById(Mockito.anyLong())).willReturn(Optional.ofNullable(facility));
            doNothing().when(facilityRepository).delete(any(Facility.class));

            facilityService.deleteFacility(facilityId);

            then(facilityRepository).should(times(1)).delete(any());
            then(facilityRepository).should(times(1)).delete(any());
            then(facilityRepository).should(times(1)).delete(any());
        }
    }
    @Nested
    @DisplayName("fail DeleteFacility case")
    class failDeleteFacilityCase {
        @Test
        @DisplayName("fail DeleteFacility test 1 -> ")
        public void failPostFacility() throws Exception {
//            given(facilityCategoryCheckListener.checkExistsByCategoryCode(Mockito.anyString())).willReturn(true);
//            Facility result = facilityService.postFacility(facilityDtoReq);
//
//            assertThat(result, is(nullValue()));
        }

        @Test
        @DisplayName("fail DeleteFacility test 2 -> not found facility")
        public void failDeleteFacilityNotFound() throws Exception {
//            given(facilityCategoryCheckListener.checkExistsByCategoryCode(Mockito.anyString()))
//                    .willReturn(false);
//
//            Exception exception = Assertions.assertThrows(Exception.class, () -> {
//                facilityService.postFacility(facilityDtoReq);
//            });
//
//            assertThat(exception.getMessage(), equalTo("Not Found Category"));
        }
    }
}
