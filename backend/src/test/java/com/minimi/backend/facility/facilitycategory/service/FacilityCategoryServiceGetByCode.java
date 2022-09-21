package com.minimi.backend.facility.facilitycategory.service;


import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryRepository;
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
@DisplayName("FacilityCategoryServiceGetByCode test")
public class FacilityCategoryServiceGetByCode {

    @Mock
    private FacilityCategoryRepository facilityCategoryRepository;

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
        @DisplayName("success Test -> get by code")
        public void successTest1() throws Exception{
            given(facilityCategoryRepository.existsByCategoryCode(Mockito.anyString()))
                    .willReturn(true);
            given(facilityCategoryRepository.findByCategoryCode(Mockito.anyString()))
                    .willReturn(facilityCategory);

            FacilityCategory result = facilityCategoryService.getFacilityCategoryByCategoryCode("222222");

            then(facilityCategoryRepository).should(times(1)).existsByCategoryCode(anyString());
            then(facilityCategoryRepository).should(times(1)).findByCategoryCode(anyString());
            assertThat(result, equalTo(facilityCategory));
        }
    }
    @Nested
    @DisplayName("fail case")
    class failCase{

        @Test
        @DisplayName("fail Test -> not exists code")
        public void successTest1() throws Exception{
            given(facilityCategoryRepository.existsByCategoryCode(Mockito.anyString()))
                    .willReturn(false);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                FacilityCategory result = facilityCategoryService.getFacilityCategoryByCategoryCode("222222");
            });

            then(facilityCategoryRepository).should(times(1)).existsByCategoryCode(anyString());
            assertThat(exception.getMessage(), equalTo("Null FacilityCategory"));
        }
    }
}
