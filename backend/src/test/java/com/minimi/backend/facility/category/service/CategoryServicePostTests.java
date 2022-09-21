package com.minimi.backend.facility.category.service;


import com.minimi.backend.facility.category.domain.Category;
import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.category.domain.CategoryRepository;
import com.minimi.backend.facility.category.domain.CategoryStatus;
import com.minimi.backend.facility.category.service.publisher.CategoryPostEvent;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("postCategory test")
public class CategoryServicePostTests {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Category category;
    private CategoryDto.request categoryDtoRequest;

    @BeforeEach
    public void setup() {
        category = new Category(1L, "220901", "헬스", CategoryStatus.ACTIVE);
        categoryDtoRequest = new CategoryDto.request("220901","헬스", CategoryStatus.ACTIVE);
    }

    @Nested
    @DisplayName("success postCategory case")
    class successPostCategoryCase {
        @Test
        @DisplayName("success postCategory test 1 -> create")
        public void successPostCategory() throws Exception {
            given(categoryRepository.existsByCategoryTitle(Mockito.anyString())).willReturn(false);
            given(categoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(false);
            given(categoryRepository.save(Mockito.any(Category.class))).willReturn(category);

            Category result = categoryService.postCategory(categoryDtoRequest);

            then(categoryRepository).should(times(1)).save(any());
            then(categoryRepository).should(times(1)).existsByCategoryCode(any());
            then(categoryRepository).should(times(1)).existsByCategoryTitle(any());
            assertThat(result, equalTo(category));
        }
    }

    @Nested
    @DisplayName("fail postCategory case")
    class failPostCategoryCase {
        @Test
        @DisplayName("fail postCategory test 1 -> blank")
        public void failTest1() throws Exception {
            CategoryDto.request categoryDtoBlank = new CategoryDto.request("","", CategoryStatus.ACTIVE);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                        categoryService.postCategory(categoryDtoBlank);
                    });

            assertThat(exception.getMessage(), equalTo("Null Value"));
        }
        @Test
        @DisplayName("fail postCategory test 2 -> null")
        public void failTest2() throws Exception {
            CategoryDto.request categoryDtoNull = CategoryDto.request.builder()
                    .categoryCode("220222")
                    .categoryTitle("헬스").build();

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                categoryService.postCategory(categoryDtoNull);
            });

            assertThat(exception.getMessage(), equalTo("Null Value"));
        }

        @Test
        @DisplayName("fail postCategory test 3 -> existsCategoryTitle")
        public void failTest3() throws Exception {
            given(categoryRepository.existsByCategoryTitle(Mockito.anyString()))
                    .willReturn(true);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                categoryService.postCategory(categoryDtoRequest);
            });

            then(categoryRepository).should(times(1)).existsByCategoryTitle(any());
            assertThat(exception.getMessage(), equalTo("Exists CategoryTitle"));
        }

        @Test
        @DisplayName("fail postCategory test 4 -> existsCategoryCode")
        public void failTest4() throws Exception {
            given(categoryRepository.existsByCategoryCode(Mockito.anyString()))
                    .willReturn(true);

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                categoryService.postCategory(categoryDtoRequest);
            });

            then(categoryRepository).should(times(1)).existsByCategoryCode(any());
            assertThat(exception.getMessage(), equalTo("Exists CategoryCode"));
        }
    }
}
