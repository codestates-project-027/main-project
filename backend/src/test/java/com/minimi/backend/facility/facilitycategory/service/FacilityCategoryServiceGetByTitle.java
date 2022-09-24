package com.minimi.backend.facility.facilitycategory.service;


import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryDto;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryRepository;
import com.minimi.backend.facility.facilitycategory.mapper.FacilityCategoryMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("FacilityCategoryServiceGetByTitle test")
public class FacilityCategoryServiceGetByTitle {

    @Mock
    private FacilityCategoryRepository facilityCategoryRepository;

    @Mock
    private FacilityCategoryMapper facilityCategoryMapper;

    @InjectMocks
    private FacilityCategoryServiceImpl facilityCategoryService;

    private FacilityCategory facilityCategory;

    @BeforeEach
    void setup(){
        facilityCategory = new FacilityCategory(1L,"222222", "헬스");
    }

    @Nested
    @DisplayName("success case")
    class successCase{

        @Test
        @DisplayName("success Test -> get by title")
        public void successTest1() throws Exception{
            given(facilityCategoryRepository.existsByCategoryTitle(Mockito.anyString()))
                    .willReturn(true);
            given(facilityCategoryRepository.findByCategoryTitle(Mockito.anyString()))
                    .willReturn(facilityCategory);
            given(facilityCategoryMapper.facilityCategoryToFacilityCategoryDtoResponse(facilityCategory))
                    .willReturn(Mockito.any(FacilityCategoryDto.response.class));

            facilityCategoryService.getFacilityCategoryByTitle("헬스");

            then(facilityCategoryRepository).should(times(1)).existsByCategoryTitle(anyString());
            then(facilityCategoryRepository).should(times(1)).findByCategoryTitle(anyString());
            then(facilityCategoryMapper).should(times(1))
                    .facilityCategoryToFacilityCategoryDtoResponse(facilityCategory);
        }
    }
    @Nested
    @DisplayName("fail case")
    class failCase{

        @Test
        @DisplayName("fail Test -> not exists title")
        public void successTest1() throws Exception{
            given(facilityCategoryRepository.existsByCategoryTitle(Mockito.anyString()))
                    .willReturn(false);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                        facilityCategoryService.getFacilityCategoryByTitle("헬스");
                    });

            then(facilityCategoryRepository).should(times(1)).existsByCategoryTitle(anyString());
            assertThat(exception.getMessage(), equalTo("Null FacilityCategory"));
        }
    }
}
