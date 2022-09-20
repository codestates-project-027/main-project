package com.minimi.backend.facility.facility.service;



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

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("postFacility test")
public class FacilityServicePostTests {

    @Mock
    private FacilityRepository facilityRepository;

    @Mock
    private FacilityCategoryCheckListener facilityCategoryCheckListener;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private FacilityServiceImpl facilityService;


    private Facility facility;
    private FacilityDto.request facilityDtoReq;

    @BeforeEach
    public void setup () {
        facility = new Facility(
                1L,"미니미헬스장","대표이미지",
                new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                "시설정보","서울특별시 강남구","www.website.com",
                "010-0000-0000","34.12345, 119.12345", 4,
                new ArrayList<>(Arrays.asList("헬스", "PT")), FacilityStatus.PENDING
                );
        facilityDtoReq = new FacilityDto.request("미니미헬스장","대표이미지",
                new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                "시설정보","서울특별시 강남구", "www.website.com",
                "0110-0000-0000","34.12345, 119.12345",
                new ArrayList<>(Arrays.asList("헬스", "PT")));
    }

    @Nested
    @DisplayName("success postFacility case")
    class successPostFacilityCase {
        @Test
        @DisplayName("success postFacility test 1 -> create")
        public void successPostFacility() throws Exception {
            given(facilityCategoryCheckListener.checkExistsByCategoryCode(Mockito.anyString())).willReturn(true);
            given(facilityRepository.save(Mockito.any(Facility.class))).willReturn(facility);

            Facility result = facilityService.postFacility(facilityDtoReq);

            then(facilityRepository).should(times(1)).save(any());
            assertThat(result, equalTo(facility));
        }
    }
    @Nested
    @DisplayName("fail postFacility case")
    class failPostFacilityCase {
        @Test
        @DisplayName("fail postFacility test 1 -> null")
        public void failPostFacility() throws Exception {
            given(facilityCategoryCheckListener.checkExistsByCategoryCode(Mockito.anyString()))
                    .willReturn(true);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                facilityService.postFacility(facilityDtoReq);
            });

            then(facilityCategoryCheckListener)
                    .should(times(2)).checkExistsByCategoryCode(anyString());

            assertThat(exception.getMessage(), is(nullValue()));
        }

        @Test
        @DisplayName("fail postFacility test 2 -> not found category")
        public void failPostFacilityNoCategory() throws Exception {
            given(facilityCategoryCheckListener.checkExistsByCategoryCode(Mockito.anyString()))
                    .willReturn(false);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                facilityService.postFacility(facilityDtoReq);
            });

            then(facilityCategoryCheckListener)
                    .should(times(1)).checkExistsByCategoryCode(anyString());
            assertThat(exception.getMessage(), equalTo("Not Found Category"));
        }
    }
}
