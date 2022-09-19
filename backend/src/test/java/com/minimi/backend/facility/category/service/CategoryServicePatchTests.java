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

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("patchCategory test")
public class CategoryServicePatchTests {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Category category;
    private CategoryDto.patch CategoryDtoPatch;
    private String categoryCode;

    @BeforeEach
    public void setup(){
        category = new Category(1L, "220901","헬스", CategoryStatus.활성);
        CategoryDtoPatch = new CategoryDto.patch("헬스",CategoryStatus.비활성);
        categoryCode = "220901";
    }

    @Nested
    @DisplayName("success patchCategory case")
    class successPatchCategoryCase{
        @Test
        @DisplayName("success patchCategory test 1 -> patch")
        public void successPatchCategory() throws Exception{
            given(categoryRepository.findByCategoryCode(Mockito.anyString()))
                    .willReturn(Optional.of(category));
            given(categoryRepository.existsByCategoryTitle(Mockito.anyString()))
                    .willReturn(false);
            given(categoryRepository.save(category))
                    .willReturn(category);

            Category result = categoryService.patchCategory(categoryCode,CategoryDtoPatch);

            then(categoryRepository).should(times(1)).findByCategoryCode(any());
            then(categoryRepository).should(times(1)).existsByCategoryTitle(any());
            then(categoryRepository).should(times(1)).save(any());
            assertThat(result, equalTo(category));
        }
    }
    @Nested
    @DisplayName("fail patchCategory case")
    class failPatchCategoryCase{
        @Test
        @DisplayName("fail patchCategory test 1 -> exists CategoryTitle")
        public void failPatchCategoryExistsCategoryTitle() throws Exception {
            given(categoryRepository.findByCategoryCode(Mockito.anyString())).willReturn(Optional.of(category));
            given(categoryRepository.existsByCategoryTitle(Mockito.anyString()))
                    .willReturn(true);

            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                categoryService.patchCategory(categoryCode, CategoryDtoPatch);
            });

            then(categoryRepository).should(times(1)).existsByCategoryTitle(any());
            then(categoryRepository).should(times(1)).findByCategoryCode(any());
            assertThat(exception.getMessage(), equalTo("Exists CategoryTitle"));
        }

        @Test
        @DisplayName("fail patchCategory test 2 -> noContent")
        public void failPatchCategoryNoContent() throws Exception {
            given(categoryRepository.findByCategoryCode(Mockito.anyString()))
                    .willThrow(new NullPointerException("NoContent CategoryCode"));

            NullPointerException exception = Assertions.assertThrows(NullPointerException.class, () -> {
                categoryService.patchCategory(categoryCode, CategoryDtoPatch);
            });

            then(categoryRepository).should(times(1)).findByCategoryCode(any());
            assertThat(exception.getMessage(),equalTo("NoContent CategoryCode"));
        }
    }
}

