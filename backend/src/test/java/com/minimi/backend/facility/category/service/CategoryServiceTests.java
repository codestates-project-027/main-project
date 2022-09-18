package com.minimi.backend.facility.category.service;



import com.minimi.backend.facility.category.domain.Category;
import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.category.domain.CategoryRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTests {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Nested
    @DisplayName("postCategory test")
    class postCategory{
        private Category category;
        private CategoryDto.request CategoryDtoRequest;
        @BeforeEach
        public void setup(){
            category = new Category(1L, "220901","헬스","활성");
            CategoryDtoRequest = new CategoryDto.request("헬스","활성");
        }

        @Nested
        @DisplayName("success postCategory case")
        class successPostCategoryCase{
            @Test
            @DisplayName("success postCategory test 1 -> create")
            public void successPostCategory() throws Exception {
                given(categoryRepository.save(Mockito.any(Category.class))).willReturn(category);

                Category result = categoryService.postCategory(CategoryDtoRequest);

                then(categoryRepository).should(times(1)).save(any());
                assertThat(result, equalTo(category));
            }
        }
        @Nested
        @DisplayName("fail postCategory case")
        class failPostCategoryCase{
            @Test
            @DisplayName("fail postCategory test 1 -> null")
            public void failPostCategoryNull() throws Exception {

                Category result = categoryService.postCategory(CategoryDtoRequest);

                assertThat(result, is(nullValue()));
            }

            @Test
            @DisplayName("fail postCategory test 2 -> existsCategoryTitle")
            public void failPostCategoryExistsTitle() throws Exception {
                given(categoryRepository.save(Mockito.any(Category.class)))
                        .willThrow(new RuntimeException("exists CategoryTitle"));

                Exception exception = Assertions.assertThrows(Exception.class, () -> {
                    categoryService.postCategory(CategoryDtoRequest);
                });

                assertThat(exception.getMessage(),equalTo("exists CategoryTitle"));
            }

        }

    }

    @Nested
    @DisplayName("patchCategory test")
    class patchCategory {
        private Category category;
        private CategoryDto.request CategoryDtoRequest;
        private String categoryCode;

        @BeforeEach
        public void setup(){
            category = new Category(1L, "220901","헬스","활성");
            CategoryDtoRequest = new CategoryDto.request("헬스","비활성");
            categoryCode = "220901";
        }
        @Nested
        @DisplayName("success patchCategory case")
        class successPatchCategoryCase{
            @Test
            @DisplayName("success patchCategory test 1 -> patch")
            public void successPatchCategory() throws Exception{
                given(categoryRepository.save(category)).willReturn(category);
                given(categoryRepository.findByCategoryCode(Mockito.anyString())).willReturn(Optional.of(category));

                Category result = categoryService.patchCategory(categoryCode,CategoryDtoRequest);

                then(categoryRepository).should(times(1)).save(any());
                then(categoryRepository).should(times(1)).findByCategoryCode(any());
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
                given(categoryRepository.save(Mockito.any(Category.class)))
                        .willThrow(new RuntimeException("exists CategoryTitle"));

                RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
                    categoryService.patchCategory(categoryCode, CategoryDtoRequest);
                });
                assertThat(exception.getMessage(), equalTo("exists CategoryTitle"));
            }
            @Test
            @DisplayName("fail patchCategory test 2 -> noContent")
            public void failPatchCategoryNoContent() throws Exception {
                given(categoryRepository.findByCategoryCode(Mockito.anyString()))
                        .willThrow(new NullPointerException("noContent CategoryCode"));

                NullPointerException exception = Assertions.assertThrows(NullPointerException.class, () -> {
                    categoryService.patchCategory(categoryCode, CategoryDtoRequest);
                });

                assertThat(exception.getMessage(),equalTo("noContent CategoryCode"));
            }
        }
    }
}
