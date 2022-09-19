package com.minimi.backend.facility.category.service;


import com.minimi.backend.facility.category.domain.Category;
import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.category.domain.CategoryRepository;
import com.minimi.backend.facility.category.domain.CategoryStatus;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("checkCategory test")
public class CategoryServiceCheckTests {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private String title;

    @BeforeEach
    public void setup() {
        title = "헬스";
    }

    @Nested
    @DisplayName("check title")
    class checkTitle {
        @Nested
        @DisplayName("success checkTitle case")
        class successCheckCategoryCase {
            @Test
            @DisplayName("success checkTitle test 1 -> titleCheck")
            public void successCheckTitleCategory() throws Exception {
                given(categoryRepository.existsByCategoryTitle(Mockito.anyString()))
                        .willReturn(false);

                String result = categoryService.checkTitle(title);
                String notExistsTitle = "NotExistsTitle";

                then(categoryRepository).should(times(1)).existsByCategoryTitle(any());
                assertThat(result, equalTo(notExistsTitle));
            }
        }
        @Nested
        @DisplayName("fail checkTitle case")
        class failCheckCategoryCase {
            @Test
            @DisplayName("fail checkTitle test 1 -> titleCheck")
            public void failCheckTitleCategory() throws Exception {
                given(categoryRepository.existsByCategoryTitle(Mockito.anyString()))
                        .willReturn(true);

                Exception exception = Assertions.assertThrows(Exception.class, () -> {
                    categoryService.checkTitle(title);
                });

                then(categoryRepository).should(times(1)).existsByCategoryTitle(any());
                assertThat(exception.getMessage(), equalTo("Exists CategoryTitle"));
            }
        }
    }
}
