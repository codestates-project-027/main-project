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
import static org.mockito.ArgumentMatchers.*;
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
        category = new Category(1L, "220901","헬스장", CategoryStatus.ACTIVE);
        CategoryDtoPatch = new CategoryDto.patch("헬스",CategoryStatus.INACTIVE);
        categoryCode = "220901";
    }

    @Nested
    @DisplayName("success patchCategory case")
    class successPatchCategoryCase{
        @Test
        @DisplayName("success patchCategory test 1 -> patch all")
        public void successPatchCategoryAll() throws Exception{
            given(categoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(true);
            given(categoryRepository.findByCategoryCode(Mockito.anyString()))
                    .willReturn(category);
            given(categoryRepository.existsByCategoryTitle(Mockito.anyString()))
                    .willReturn(false);
            given(categoryRepository.save(category))
                    .willReturn(category);

            Category result = categoryService.patchCategory(categoryCode,CategoryDtoPatch);

            then(categoryRepository).should(times(1)).existsByCategoryCode(anyString());
            then(categoryRepository).should(times(1)).findByCategoryCode(any());
            then(categoryRepository).should(times(1)).existsByCategoryTitle(any());
            then(categoryRepository).should(times(1)).save(any());
            assertThat(result, equalTo(category));
        }
        @Test
        @DisplayName("success patchCategory test 2 -> patch title null code")
        public void successPatchCategoryTitle() throws Exception{
            CategoryDto.patch patchTitle = CategoryDto.patch.builder().categoryTitle("PT").build();
            Category categoryTitle = new Category(1L, categoryCode, "PT",CategoryStatus.ACTIVE);
            given(categoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(true);
            given(categoryRepository.findByCategoryCode(Mockito.anyString()))
                    .willReturn(category);
            given(categoryRepository.existsByCategoryTitle(Mockito.anyString()))
                    .willReturn(false);
            given(categoryRepository.save(category))
                    .willReturn(categoryTitle);

            Category result = categoryService.patchCategory(categoryCode,patchTitle);

            then(categoryRepository).should(times(1)).existsByCategoryCode(anyString());
            then(categoryRepository).should(times(1)).findByCategoryCode(any());
            then(categoryRepository).should(times(1)).existsByCategoryTitle(any());
            then(categoryRepository).should(times(1)).save(any());
            assertThat(result, equalTo(categoryTitle));
        }
        @Test
        @DisplayName("success patchCategory test 3 -> patch code null title")
        public void successPatchCategoryCodeNullTitle() throws Exception{
            CategoryDto.patch patchTitle = CategoryDto.patch.builder().categoryStatus(CategoryStatus.INACTIVE).build();
            Category categoryTitle = new Category(1L, categoryCode, "헬스장",CategoryStatus.INACTIVE);
            given(categoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(true);
            given(categoryRepository.findByCategoryCode(Mockito.anyString()))
                    .willReturn(category);
            given(categoryRepository.save(category))
                    .willReturn(categoryTitle);

            Category result = categoryService.patchCategory(categoryCode,patchTitle);

            then(categoryRepository).should(times(1)).existsByCategoryCode(anyString());
            then(categoryRepository).should(times(1)).findByCategoryCode(any());
            then(categoryRepository).should(times(1)).save(any());
            assertThat(result, equalTo(categoryTitle));
        }
        @Test
        @DisplayName("success patchCategory test 4 -> patch code blank title")
        public void successPatchCategoryCodeBlankTitle() throws Exception{
            CategoryDto.patch patchTitle = CategoryDto.patch.builder().categoryTitle("").categoryStatus(CategoryStatus.INACTIVE).build();
            Category categoryTitle = new Category(1L, categoryCode, "헬스장",CategoryStatus.INACTIVE);
            given(categoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(true);
            given(categoryRepository.findByCategoryCode(Mockito.anyString()))
                    .willReturn(category);
            given(categoryRepository.existsByCategoryTitle(Mockito.anyString()))
                    .willReturn(false);
            given(categoryRepository.save(category))
                    .willReturn(categoryTitle);

            Category result = categoryService.patchCategory(categoryCode,patchTitle);

            then(categoryRepository).should(times(1)).existsByCategoryCode(anyString());
            then(categoryRepository).should(times(1)).findByCategoryCode(any());
            then(categoryRepository).should(times(1)).existsByCategoryTitle(any());
            then(categoryRepository).should(times(1)).save(any());
            assertThat(result, equalTo(categoryTitle));
        }
        @Test
        @DisplayName("success patchCategory test 5 -> patch code same title")
        public void successPatchCategoryCodeSameTitle() throws Exception{
            CategoryDto.patch patchTitle = CategoryDto.patch.builder().categoryTitle("헬스장").categoryStatus(CategoryStatus.INACTIVE).build();
            Category categoryTitle = new Category(1L, categoryCode, "헬스장",CategoryStatus.INACTIVE);
            given(categoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(true);
            given(categoryRepository.findByCategoryCode(Mockito.anyString()))
                    .willReturn(category);
            given(categoryRepository.save(category))
                    .willReturn(categoryTitle);

            Category result = categoryService.patchCategory(categoryCode,patchTitle);

            then(categoryRepository).should(times(1)).existsByCategoryCode(anyString());
            then(categoryRepository).should(times(1)).findByCategoryCode(any());
            then(categoryRepository).should(times(1)).save(any());
            assertThat(result, equalTo(categoryTitle));
        }
    }

    @Nested
    @DisplayName("fail patchCategory case")
    class failPatchCategoryCase{
        @Test
        @DisplayName("fail patchCategory test 1 -> exists CategoryTitle")
        public void failPatchCategoryExistsCategoryTitle() throws Exception {
            given(categoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(true);
            given(categoryRepository.findByCategoryCode(Mockito.anyString())).willReturn(category);
            given(categoryRepository.existsByCategoryTitle(Mockito.anyString()))
                    .willReturn(true);

            RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                categoryService.patchCategory(categoryCode, CategoryDtoPatch);
            });

            then(categoryRepository).should(times(1)).existsByCategoryCode(anyString());
            then(categoryRepository).should(times(1)).existsByCategoryTitle(any());
            then(categoryRepository).should(times(1)).findByCategoryCode(any());
            assertThat(exception.getMessage(), equalTo("Exists CategoryTitle"));
        }

        @Test
        @DisplayName("fail patchCategory test 2 -> noContent")
        public void failPatchCategoryNoContent() throws Exception {
            given(categoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(false);

            NullPointerException exception = Assertions.assertThrows(NullPointerException.class, () -> {
                categoryService.patchCategory(categoryCode, CategoryDtoPatch);
            });

            then(categoryRepository).should(times(1)).existsByCategoryCode(anyString());
            assertThat(exception.getMessage(),equalTo("Not Found Category"));
        }
    }
}

