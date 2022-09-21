package com.minimi.backend.facility.facilitycategory.service;

import com.minimi.backend.facility.category.domain.Category;
import com.minimi.backend.facility.category.domain.CategoryStatus;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("FacilityCategoryServicePatchTests test")
public class FacilityCategoryServicePatchTests {

    @Mock
    private FacilityCategoryRepository facilityCategoryRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private FacilityCategoryServiceImpl facilityCategoryService;

    private FacilityCategory facilityCategory;
    private FacilityCategory facilityCategoryResult;
    private String categoryTitle;
    private String categoryCode;

    @BeforeEach
    public void setup(){
        facilityCategory = new FacilityCategory(1L, "220901","헬스장");
        facilityCategoryResult = new FacilityCategory(1L, "220901",categoryTitle);
        categoryCode = "220901";
        categoryTitle = "헬스";
    }

    @Nested
    @DisplayName("success case")
    class successCase{
        @Test
        @DisplayName("success test 1 -> patch all")
        public void successTest1() throws Exception{
            Category categoryResult = new Category(1L, "220901","헬스", CategoryStatus.INACTIVE);
            given(facilityCategoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(true);
            given(facilityCategoryRepository.findByCategoryCode(Mockito.anyString()))
                    .willReturn(facilityCategory);
            given(facilityCategoryRepository.existsByCategoryTitle(Mockito.anyString()))
                    .willReturn(false);
            given(facilityCategoryRepository.save(Mockito.any(FacilityCategory.class)))
                    .willReturn(facilityCategoryResult);

            FacilityCategory result = facilityCategoryService.patchFacilityCategory(categoryCode,categoryTitle);

            then(facilityCategoryRepository).should(times(1)).existsByCategoryCode(anyString());
            then(facilityCategoryRepository).should(times(1)).findByCategoryCode(any());
            then(facilityCategoryRepository).should(times(1)).existsByCategoryTitle(any());
            then(facilityCategoryRepository).should(times(1)).save(any());
            assertThat(result.getFacilityCategoryId(), equalTo(facilityCategoryResult.getFacilityCategoryId()));
            assertThat(result.getCategoryCode(), equalTo(facilityCategoryResult.getCategoryCode()));
            assertThat(result.getCategoryTitle(), equalTo(facilityCategoryResult.getCategoryTitle()));
        }
    }

    @Nested
    @DisplayName("fail case")
    class failCase{
        @Test
        @DisplayName("fail test 1 -> not exists CategoryCode")
        public void failTest() throws Exception {
            given(facilityCategoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(false);

            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                facilityCategoryService.patchFacilityCategory(categoryCode, categoryTitle);
            });

            then(facilityCategoryRepository).should(times(1)).existsByCategoryCode(anyString());
            assertThat(exception.getMessage(), equalTo("Null FacilityCategory"));
        }

        @Test
        @DisplayName("fail test 2 -> exists CategoryTitle")
        public void failTest2() throws Exception {
            given(facilityCategoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(true);
            given(facilityCategoryRepository.findByCategoryCode(Mockito.anyString()))
                    .willReturn(facilityCategory);
            given(facilityCategoryRepository.existsByCategoryTitle(Mockito.anyString()))
                    .willReturn(true);

            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                facilityCategoryService.patchFacilityCategory(categoryCode, categoryTitle);
            });

            then(facilityCategoryRepository).should(times(1)).existsByCategoryCode(anyString());
            then(facilityCategoryRepository).should(times(1)).findByCategoryCode(any());
            then(facilityCategoryRepository).should(times(1)).existsByCategoryTitle(any());
            assertThat(exception.getMessage(), equalTo("Exists CategoryTitle"));
        }
    }
}

