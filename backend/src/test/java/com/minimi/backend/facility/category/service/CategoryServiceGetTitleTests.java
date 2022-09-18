package com.minimi.backend.facility.category.service;

import com.minimi.backend.facility.category.domain.Category;
import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.category.domain.CategoryRepository;
import com.minimi.backend.facility.category.mapper.CategoryMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
@DisplayName("getTitleCategory test")
public class CategoryServiceGetTitleTests {
    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryMapper categoryMapper;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private List<Category> categoryList;
    private List<CategoryDto.response> categoryDtoList;

    @BeforeEach
    public void setup(){
        categoryList = new ArrayList<>(Arrays.asList(
                new Category(1L,"220901","헬스","활성"),
                new Category(2L,"220902","요가","비활성")
        ));
        categoryDtoList = new ArrayList<>(Arrays.asList(
                new CategoryDto.response("220901","헬스","활성"),
                new CategoryDto.response("220902","요가","비활성")
        ));
    }

    @Nested
    @DisplayName("success patchCategory case")
    class successGetTitleCategoryCase {

        @Test
        @DisplayName("success getTitleCategory test 1 -> getTitle")
        public void successGetTitleCategory() throws Exception {
            given(categoryRepository.findAll()).willReturn(categoryList);
            given(categoryMapper.categoryListToCategoryDtoResponseList(Mockito.anyList())).willReturn(categoryDtoList);

            List<CategoryDto.response> result = categoryService.getCategoryTitles();

            then(categoryRepository).should(times(1)).findAll();
            then(categoryMapper).should(times(1)).categoryListToCategoryDtoResponseList(anyList());
            assertThat(result, equalTo(categoryDtoList));
        }
    }
}
