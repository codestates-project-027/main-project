package com.minimi.backend.facility.category.service;


import com.minimi.backend.facility.facility.FacilityDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("getSliceFacilityCategory test")
public class CategoryServiceGetCategoryFacilityTests {

    @Mock
    private CategoryFacilityListener categoryFacilityListener;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private String categoryTitle;
    private int page;
    private List<FacilityDto.responsePage> facilityList;

    @BeforeEach
    public void setup(){
        categoryTitle = "헬스";
        page = 1;
        facilityList = new ArrayList<>(Arrays.asList(
                new FacilityDto.responsePage(
                        1L,"파워헬스장","대표이미지","서울특별시 강남구",3,
                        "35.123456, 119.123456", new ArrayList<>(Arrays.asList("헬스")),"영업중"),
                new FacilityDto.responsePage(
                        2L,"종국헬스장","대표이미지","서울특별시 강북구",2,
                        "35.123456, 120.123456", new ArrayList<>(Arrays.asList("헬스", "PT")),"영업종료"),
                new FacilityDto.responsePage(
                        3L,"미니미헬스장","대표이미지","서울특별시 강남구",5,
                        "35.123456, 119.123456", new ArrayList<>(Arrays.asList("헬스", "요가")),"영업중")
        ));
    }

    @Nested
    @DisplayName("success getSliceFacilityCategory case")
    class getSliceFacilityCategorySuccess {

        @Test
        @DisplayName("success getSliceFacilityCategory test 1 -> getFacilitySlice")
        public void successGetTitleCategoryTest() throws Exception {
            Slice<FacilityDto.responsePage> categorySlice = new SliceImpl<>(facilityList, PageRequest.of(page-1, 5),false);
            given(categoryFacilityListener.getCategory(Mockito.anyString(),Mockito.anyInt())).willReturn(categorySlice);

            Slice<FacilityDto.responsePage> result = categoryService.getCategory(categoryTitle,page);

            then(categoryFacilityListener).should(times(1)).getCategory(anyString(), anyInt());
            assertThat(result, equalTo(categorySlice));
        }
    }

    @Nested
    @DisplayName("fail getSliceFacilityCategory case")
    class getSliceFacilityCategoryFail {
        @Test
        @DisplayName("fail getSliceFacilityCategory test 1 -> null")
        public void categoryFacilityListener() throws Exception {
            given(categoryFacilityListener.getCategory(Mockito.anyString(),Mockito.anyInt()))
                    .willReturn(null);

            Slice<FacilityDto.responsePage> result = categoryService.getCategory(categoryTitle, page);

            then(categoryFacilityListener).should(times(1)).getCategory(anyString(), anyInt());
            assertThat(result, is(nullValue()));
        }
    }
}