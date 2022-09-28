package com.minimi.backend.facility.facamapping.service;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facamapping.domain.FacaMapping;
import com.minimi.backend.facility.facamapping.domain.FacaMappingRepository;
import com.minimi.backend.facility.facamapping.mapper.FacaMappingMapper;
import com.minimi.backend.facility.facamapping.service.listener.FacilityCategoryGetIdListener;
import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facility.domain.FacilityStatus;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryDto;
import com.minimi.backend.facility.facilitycategory.mapper.FacilityCategoryMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

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
@DisplayName("facaMapping GetPage test")
public class FacaMappingServiceGetPageTests {

    @Mock
    private FacaMappingRepository facaMappingRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @Mock
    private FacilityCategoryGetIdListener facilityCategoryGetIdListener;

    @Mock
    private FacaMappingMapper facaMappingMapper;

    @Mock
    private FacilityCategoryMapper facilityCategoryMapper;

    @InjectMocks
    private FacaMappingServiceImpl facaMappingService;


    private Slice<ResponseFacilityDto.facilityPageFromCategory> facilitySlice;

    private Slice<FacaMapping> facaMappingSlice;

    private Slice<FacaMapping> nullFacaSlice;
    private String categoryCode;

    private ResponseFacilityDto.facilityPageFromCategory facilityDto1;
    private ResponseFacilityDto.facilityPageFromCategory facilityDto2;
    private ResponseFacilityDto.facilityPageFromCategory facilityDto3;
    private int page;

    private FacilityCategory facilityCategory;
    private FacilityCategoryDto.response facilityCategoryDtoRes;

    @BeforeEach
    public void setup(){
        facilityCategory = new FacilityCategory(1L, "220901", "헬스");
        facilityCategoryDtoRes = new FacilityCategoryDto.response(1L,"220901", "헬스");
        categoryCode = "220901";
        page = 1;
        nullFacaSlice = new SliceImpl<>(new ArrayList<>());
        facaMappingSlice = new SliceImpl<>(
                new ArrayList<>(Arrays.asList(
                        new FacaMapping(1L,1L,1L,
                                facilityCategory,
                                new Facility(
                                        1L,"파워헬스장",
                                        new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                                        "시설정보","서울특별시 강남구","www.website.com",
                                        "010-0000-0000","35.123456, 119.123456", 3,
                                        new ArrayList<>(Arrays.asList("헬스", "PT")), FacilityStatus.PENDING
                                )),
                        new FacaMapping(1L,1L,2L,
                                facilityCategory,
                                new Facility(
                                        2L,"종국헬스장",
                                        new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                                        "시설정보","서울특별시 강북구","www.website.com",
                                        "010-0000-0000","35.123456, 120.123456", 2,
                                        new ArrayList<>(Arrays.asList("헬스", "PT")), FacilityStatus.PENDING
                                )),new FacaMapping(1L,1L,3L,
                                facilityCategory,
                                new Facility(
                                        3L,"미니미헬스장",
                                        new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                                        "시설정보","서울특별시 강남구","www.website.com",
                                        "010-0000-0000","35.123456, 119.123456", 5,
                                        new ArrayList<>(Arrays.asList("헬스", "요가")), FacilityStatus.PENDING
                                ))
                )));
        facilityDto1 = new ResponseFacilityDto.facilityPageFromCategory(
                1L,"파워헬스장","대표이미지","서울특별시 강남구",3,
                "35.123456, 119.123456", new ArrayList<>(Arrays.asList("헬스")), FacilityStatus.ACTIVE);
        facilityDto2 = new ResponseFacilityDto.facilityPageFromCategory(
                2L,"종국헬스장","대표이미지","서울특별시 강북구",2,
                "35.123456, 120.123456", new ArrayList<>(Arrays.asList("헬스", "PT")),FacilityStatus.INACTIVE);
        facilityDto3 = new ResponseFacilityDto.facilityPageFromCategory(
                3L,"미니미헬스장","대표이미지","서울특별시 강남구",5,
                "35.123456, 119.123456", new ArrayList<>(Arrays.asList("헬스", "요가")),FacilityStatus.ACTIVE);
        facilitySlice = new SliceImpl<>(new ArrayList<>(Arrays.asList(
                facilityDto1,facilityDto2,facilityDto3
        )));
    }

    @Nested
    @DisplayName("success case")
    public class successCase {

        @Test
        @DisplayName("success test 1 -> getPage")
        public void successTest() throws Exception{
            given(facilityCategoryGetIdListener
                    .getFacilityCategoryByCategoryCode(Mockito.anyString()))
                    .willReturn(facilityCategory);
            given(facaMappingRepository
                    .findByFacilityCategory(Mockito.any(FacilityCategory.class),Mockito.any(Pageable.class)))
                    .willReturn(facaMappingSlice);
            given(facaMappingMapper
                    .FacilityToResponseFacilityDto(any(Facility.class)))
                    .willReturn(facilityDto1,facilityDto2,facilityDto3);


            Slice<ResponseFacilityDto.facilityPageFromCategory> result =
                    facaMappingService.getCategoryFacilitySlice(categoryCode, page);


            then(facilityCategoryGetIdListener).should(times(1))
                    .getFacilityCategoryByCategoryCode(anyString());
            then(facaMappingRepository).should(times(1))
                    .findByFacilityCategory(Mockito.any(FacilityCategory.class),Mockito.any(Pageable.class));
            then(facaMappingMapper).should(times(3)).FacilityToResponseFacilityDto(any(Facility.class));
            assertThat(result, equalTo(facilitySlice));
        }
    }

    @Nested
    @DisplayName("fail case")
    public class failCase {

        @Test
        @DisplayName("fail test 1 -> null facilityCategory")
        public void failTest() throws Exception{
            given(facilityCategoryGetIdListener
                    .getFacilityCategoryByCategoryCode(Mockito.anyString()))
                    .willThrow(new NullPointerException("Null FacilityCategory"));

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                Slice<ResponseFacilityDto.facilityPageFromCategory> result =
                        facaMappingService.getCategoryFacilitySlice(categoryCode, page);
            });

            then(facilityCategoryGetIdListener).should(times(1))
                    .getFacilityCategoryByCategoryCode(anyString());
            assertThat(exception.getMessage(), equalTo("Null FacilityCategory"));

        }

        @Test
        @DisplayName("fail test 2 -> null page")
        public void failTest2() throws Exception{
            given(facilityCategoryGetIdListener
                    .getFacilityCategoryByCategoryCode(Mockito.anyString()))
                    .willReturn(facilityCategory);
            given(facaMappingRepository
                    .findByFacilityCategory(Mockito.any(FacilityCategory.class),Mockito.any(Pageable.class)))
                    .willReturn(nullFacaSlice);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                Slice<ResponseFacilityDto.facilityPageFromCategory> result =
                        facaMappingService.getCategoryFacilitySlice(categoryCode, page);
            });

            then(facilityCategoryGetIdListener).should(times(1))
                    .getFacilityCategoryByCategoryCode(anyString());
            then(facaMappingRepository).should(times(1))
                    .findByFacilityCategory(Mockito.any(FacilityCategory.class),Mockito.any(Pageable.class));
            assertThat(exception.getMessage(), equalTo("Null Slice Content"));

        }

        @Test
        @DisplayName("fail test 3 -> mapper err")
        public void failTest3() throws Exception{
            given(facilityCategoryGetIdListener
                    .getFacilityCategoryByCategoryCode(Mockito.anyString()))
                    .willReturn(facilityCategory);
            given(facaMappingRepository
                    .findByFacilityCategory(Mockito.any(FacilityCategory.class),Mockito.any(Pageable.class)))
                    .willReturn(facaMappingSlice);
            given(facaMappingMapper
                    .FacilityToResponseFacilityDto(any(Facility.class)))
                    .willThrow(new RuntimeException("Mapping Error"));

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                Slice<ResponseFacilityDto.facilityPageFromCategory> result =
                        facaMappingService.getCategoryFacilitySlice(categoryCode, page);
            });

            then(facilityCategoryGetIdListener).should(times(1))
                    .getFacilityCategoryByCategoryCode(anyString());
            then(facaMappingRepository).should(times(1))
                    .findByFacilityCategory(Mockito.any(FacilityCategory.class),Mockito.any(Pageable.class));
            then(facaMappingMapper).should(times(1))
                    .FacilityToResponseFacilityDto(any(Facility.class));
            assertThat(exception.getMessage(), equalTo("Mapping Error"));

        }
    }
}
