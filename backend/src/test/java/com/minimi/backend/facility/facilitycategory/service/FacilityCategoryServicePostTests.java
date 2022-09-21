package com.minimi.backend.facility.facilitycategory.service;

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
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("FacilityCategoryServicePost test")
public class FacilityCategoryServicePostTests {

    @Mock
    private FacilityCategoryRepository facilityCategoryRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private FacilityCategoryServiceImpl facilityCategoryService;

    private FacilityCategory facilityCategory;
    private String categoryCode;
    private String categoryTitle;

    @BeforeEach
    public void setup() {
        facilityCategory = new FacilityCategory(1L, "220901", "헬스");
        categoryCode = "220901";
        categoryTitle = "헬스";
    }

    @Nested
    @DisplayName("success FacilityCategoryServicePostTests case")
    class successCase {
        @Test
        @DisplayName("success FacilityCategoryServicePostTests test 1 -> create")
        public void successTest1() throws Exception {
            given(facilityCategoryRepository.existsByCategoryTitle(Mockito.anyString())).willReturn(false);
            given(facilityCategoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(false);
            given(facilityCategoryRepository.save(Mockito.any(FacilityCategory.class))).willReturn(facilityCategory);

            FacilityCategory result = facilityCategoryService.postFacilityCategory(categoryCode, categoryTitle);

            then(facilityCategoryRepository).should(times(1)).save(any());
            then(facilityCategoryRepository).should(times(1)).existsByCategoryCode(any());
            then(facilityCategoryRepository).should(times(1)).existsByCategoryTitle(any());
            assertThat(result, equalTo(facilityCategory));
        }
    }

    @Nested
    @DisplayName("fail FacilityCategoryServicePostTests case")
    class failCase {
        @Test
        @DisplayName("fail FacilityCategoryServicePostTests test 1 -> null")
        public void failTest1() throws Exception {
            given(facilityCategoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(false);

            categoryCode = "";
            categoryTitle = "";
            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                facilityCategoryService.postFacilityCategory(categoryCode, categoryTitle);
            });

            then(facilityCategoryRepository).should(times(1)).existsByCategoryCode(any());
            assertThat(exception.getMessage(), equalTo("Null Value"));
        }

        @Test
        @DisplayName("fail FacilityCategoryServicePostTests test 2 -> existsCategoryTitle")
        public void failTest2() throws Exception {
            given(facilityCategoryRepository.existsByCategoryTitle(Mockito.anyString()))
                    .willReturn(true);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                facilityCategoryService.postFacilityCategory(categoryCode, categoryTitle);
            });

            then(facilityCategoryRepository).should(times(1)).existsByCategoryTitle(any());
            assertThat(exception.getMessage(), equalTo("Exists CategoryTitle"));
        }

        @Test
        @DisplayName("fail FacilityCategoryServicePostTests test 3 -> existsCategoryCode")
        public void failTest3() throws Exception {
            given(facilityCategoryRepository.existsByCategoryCode(Mockito.anyString()))
                    .willReturn(true);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                facilityCategoryService.postFacilityCategory(categoryCode, categoryTitle);
            });

            then(facilityCategoryRepository).should(times(1)).existsByCategoryCode(any());
            assertThat(exception.getMessage(), equalTo("Exists CategoryCode"));
        }
    }
}
