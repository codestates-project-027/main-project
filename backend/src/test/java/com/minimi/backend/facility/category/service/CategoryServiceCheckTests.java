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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
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
    private String code;

    @BeforeEach
    public void setup() {
        title = "헬스";
        code = "220909";
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

    @Nested
    @DisplayName("check code")
    class checkCode {
        @Nested
        @DisplayName("success checkCode case")
        class successCheckCategoryCase {
            @Test
            @DisplayName("success checkTitle test 1 -> codeCheck")
            public void successCheckCodeCategory() throws Exception {
                given(categoryRepository.existsByCategoryCode(Mockito.anyString()))
                        .willReturn(false);

                String result = categoryService.checkCode(code);
                String notExistsCode = "NotExistsCode";

                then(categoryRepository).should(times(1)).existsByCategoryCode(any());
                assertThat(result, equalTo(notExistsCode));
            }
        }
        @Nested
        @DisplayName("fail checkCode case")
        class failCheckCategoryCase {
            @Test
            @DisplayName("fail checkCode test 1 -> codeCheck")
            public void failCheckCodeCategory() throws Exception {
                given(categoryRepository.existsByCategoryCode(Mockito.anyString()))
                        .willReturn(true);

                Exception exception = Assertions.assertThrows(Exception.class, () -> {
                    categoryService.checkCode(code);
                });

                then(categoryRepository).should(times(1)).existsByCategoryCode(any());
                assertThat(exception.getMessage(), equalTo("Exists CategoryCode"));
            }
        }
    }
    @Nested
    @DisplayName("checkGetCategory")
    class checkGetCategory {
        @Nested
        @DisplayName("success checkGetCategory case")
        class successCheckCategoryCase {
            @Test
            @DisplayName("success checkGetCategory test 1 -> checkGetCategory")
            public void successCheckGetCategory() throws Exception {
                Category category = new Category(1L, code, title, CategoryStatus.ACTIVE);
                given(categoryRepository.existsByCategoryCode(Mockito.anyString()))
                        .willReturn(true);
                given(categoryRepository.findByCategoryCode(Mockito.anyString()))
                        .willReturn(category);

                Category result = categoryService.getCategory(code);


                then(categoryRepository).should(times(1)).existsByCategoryCode(anyString());
                then(categoryRepository).should(times(1)).findByCategoryCode(anyString());
                assertThat(result, equalTo(category));
            }
        }

        @Nested
        @DisplayName("fail checkGetCategory case")
        class failCheckCategoryCase {
            @Test
            @DisplayName("fail checkGetCategory test 1 -> checkGetCategory")
            public void failCheckGetCategory() throws Exception {
                given(categoryRepository.existsByCategoryCode(Mockito.anyString()))
                        .willReturn(false);

                Exception exception = Assertions.assertThrows(Exception.class, () -> {
                    categoryService.getCategory(code);
                });

                then(categoryRepository).should(times(1)).existsByCategoryCode(any());
                assertThat(exception.getMessage(), equalTo("Not Found Category"));
            }
        }
    }
    @Nested
    @DisplayName("blankAndNullCheck")
    class checkBlankAndNullCheck {
        @Nested
        @DisplayName("success case")
        class successCase {
            @Test
            @DisplayName("success test 1 -> string value")
            public void successTest1() throws Exception {

                Boolean result = categoryService.blankAndNullCheck("stringValue");

                assertThat(result, equalTo(true));
            }
            @Test
            @DisplayName("success test 2 -> Object value")
            public void successTest2() throws Exception {
                CategoryStatus categoryStatus = CategoryStatus.ACTIVE;
                Boolean result = categoryService.blankAndNullCheck(categoryStatus);

                assertThat(result, equalTo(true));
            }
        }
        @Nested
        @DisplayName("fail case")
        class failCase {
            @Test
            @DisplayName("fail test 1 -> null")
            public void failTest1() throws Exception {

                Exception exception = Assertions.assertThrows(Exception.class, () -> {
                    categoryService.blankAndNullCheck(null);
                });

                assertThat(exception.getMessage(), equalTo("Null Value"));
            }

            @Test
            @DisplayName("fail test 2 -> blank")
            public void failTest2() throws Exception {

                Exception exception = Assertions.assertThrows(Exception.class, () -> {
                    categoryService.blankAndNullCheck("");
                });

                assertThat(exception.getMessage(), equalTo("Null Value"));
            }

        }
    }
}
