package com.minimi.backend.facility.facamapping.service;



import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facility.domain.FacilityStatus;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facamapping.domain.FacaMapping;
import com.minimi.backend.facility.facamapping.domain.FacaMappingRepository;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryDto;
import com.minimi.backend.facility.facilitycategory.mapper.FacilityCategoryMapper;
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
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("facaMapping post test")
public class FacaMappingServicePostTests {

    @Mock
    private FacaMappingRepository facaMappingRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @Mock
    private FacilityCategoryMapper facilityCategoryMapper;

    @InjectMocks
    private FacaMappingServiceImpl facaMappingService;

    private Facility facility;

    private FacilityCategoryDto.response facilityCategoryDtoRes;

    @BeforeEach
    public void setup(){
        facility = new Facility(
                1L,"미니미헬스장","대표이미지",
                new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                "시설정보","서울특별시 강남구","www.website.com",
                "010-0000-0000","34.12345, 119.12345", 4,
                new ArrayList<>(Arrays.asList("헬스", "PT")), FacilityStatus.PENDING
        );
        facilityCategoryDtoRes = new FacilityCategoryDto.response(
                1L,"222222","헬스"
        );
    }


    @Nested
    @DisplayName("success case")
    class successCase {

        @Test
        @DisplayName("success test 1 -> create")
        public void successTest() throws Exception {
            FacilityCategory facilityCategory = new FacilityCategory(1L,"222222","헬스");
            FacaMapping facaMapping =
                    new FacaMapping(1L, 1L,1L,facilityCategory, facility);
            given(facilityCategoryMapper.facilityCategoryDtoResponseToFacilityCategory(
                    Mockito.any(FacilityCategoryDto.response.class)))
                    .willReturn(facilityCategory);
            given(facaMappingRepository.save(Mockito.any(FacaMapping.class))).willReturn(facaMapping);


            facaMappingService.postFacaMapping(facilityCategoryDtoRes, facility);

            then(facilityCategoryMapper).should(times(1))
                    .facilityCategoryDtoResponseToFacilityCategory(
                            Mockito.any(FacilityCategoryDto.response.class));
            then(facaMappingRepository).should(times(1))
                    .save(Mockito.any(FacaMapping.class));
        }

    }
    @Nested
    @DisplayName("fail case")
    class failCase {

        @Test
        @DisplayName("fail test 1 -> null")
        public void failTest() throws Exception {

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                facaMappingService.postFacaMapping(null, null);
            });

            assertThat(exception.getMessage(), equalTo("Null Value"));
        }

        @Test
        @DisplayName("fail test 2 -> blankValue")
        public void failTest2() throws Exception {
            FacilityCategoryDto.response facilityCategoryDtoResNull = new FacilityCategoryDto.response();
            Facility facility = new Facility();

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                facaMappingService.postFacaMapping(facilityCategoryDtoResNull, facility);
            });

            assertThat(exception.getMessage(), equalTo("Null Value"));
        }
    }
}
