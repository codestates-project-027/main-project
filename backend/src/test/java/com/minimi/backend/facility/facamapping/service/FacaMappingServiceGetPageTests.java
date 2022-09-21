package com.minimi.backend.facility.facamapping.service;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facamapping.domain.FacaMapping;
import com.minimi.backend.facility.facamapping.domain.FacaMappingRepository;
import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facility.domain.FacilityStatus;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
@DisplayName("facaMapping GetPage test")
public class FacaMappingServiceGetPageTests {

    @Mock
    private FacaMappingRepository facaMappingRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private FacaMappingServiceImpl facaMappingService;


    private Slice<ResponseFacilityDto.facilityPageFromCategory> facilitySlice;

    private Slice<FacaMapping> facaMappingSlice;
    private String categoryCode;
    private int page;

    @BeforeEach
    public void setup(){
        categoryCode = "22022";
        page = 1;
        facaMappingSlice = new SliceImpl<>(
                new ArrayList<>(Arrays.asList(
                        new FacaMapping(1L,
                                new FacilityCategory(1L, "220901", "헬스"),
                                new Facility(
                                        1L,"파워헬스장","대표이미지",
                                        new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                                        "시설정보","서울특별시 강남구","www.website.com",
                                        "010-0000-0000","35.123456, 119.123456", 3,
                                        new ArrayList<>(Arrays.asList("헬스", "PT")), FacilityStatus.PENDING
                                )),
                        new FacaMapping(1L,
                                new FacilityCategory(1L, "220901", "헬스"),
                                new Facility(
                                        2L,"종국헬스장","대표이미지",
                                        new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                                        "시설정보","서울특별시 강북구","www.website.com",
                                        "010-0000-0000","35.123456, 120.123456", 2,
                                        new ArrayList<>(Arrays.asList("헬스", "PT")), FacilityStatus.PENDING
                                )),new FacaMapping(1L,
                                new FacilityCategory(1L, "220901", "헬스"),
                                new Facility(
                                        3L,"미니미헬스장","대표이미지",
                                        new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                                        "시설정보","서울특별시 강남구","www.website.com",
                                        "010-0000-0000","35.123456, 119.123456", 5,
                                        new ArrayList<>(Arrays.asList("헬스", "요가")), FacilityStatus.PENDING
                                ))
                )));
        facilitySlice = new SliceImpl<>(new ArrayList<>(Arrays.asList(
                new ResponseFacilityDto.facilityPageFromCategory(
                        1L,"파워헬스장","대표이미지","서울특별시 강남구",3,
                        "35.123456, 119.123456", new ArrayList<>(Arrays.asList("헬스")), FacilityStatus.ACTIVE),
                new ResponseFacilityDto.facilityPageFromCategory(
                        2L,"종국헬스장","대표이미지","서울특별시 강북구",2,
                        "35.123456, 120.123456", new ArrayList<>(Arrays.asList("헬스", "PT")),FacilityStatus.INACTIVE),
                new ResponseFacilityDto.facilityPageFromCategory(
                        3L,"미니미헬스장","대표이미지","서울특별시 강남구",5,
                        "35.123456, 119.123456", new ArrayList<>(Arrays.asList("헬스", "요가")),FacilityStatus.ACTIVE)
        )));
    }

    @Nested
    @DisplayName("success case")
    public class successCase {

        @Test
        @DisplayName("success test 1 -> getPage")
        public void successTest() throws Exception{

            given(facaMappingRepository.findByFacilityCategoryId(Mockito.anyLong(),Mockito.any(Pageable.class)))
                    .willReturn(facaMappingSlice);

            Slice<ResponseFacilityDto.facilityPageFromCategory> result =
                    facaMappingService.getCategoryFacilitySlice(categoryCode, page);

            assertThat(result, equalTo(facilitySlice));
        }
    }

    @Nested
    @DisplayName("fail case")
    public class failCase {

        @Test
        @DisplayName("fail test 1 -> null")
        public void failTest() throws Exception{

        }
    }
}
