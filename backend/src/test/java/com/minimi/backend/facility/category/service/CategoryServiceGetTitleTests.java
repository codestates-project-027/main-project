package com.minimi.backend.facility.category.service;

import com.minimi.backend.facility.category.domain.Category;
import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.category.domain.CategoryRepository;
import com.minimi.backend.facility.category.domain.CategoryStatus;
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
import static org.hamcrest.Matchers.*;
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
    private List<Category> categoryList1;
    private List<CategoryDto.response> categoryDtoList1;

    @BeforeEach
    public void setup(){
        categoryList = new ArrayList<>(Arrays.asList(
                new Category(1L,"220901","헬스", CategoryStatus.ACTIVE),
                new Category(2L,"220902","요가", CategoryStatus.INACTIVE)
        ));
        categoryDtoList = new ArrayList<>(Arrays.asList(
                new CategoryDto.response("220901","헬스",CategoryStatus.ACTIVE),
                new CategoryDto.response("220902","요가",CategoryStatus.INACTIVE)
        ));
        categoryList1 = new ArrayList<>(Arrays.asList(
                new Category(1L,"220901","헬스", CategoryStatus.ACTIVE),
                new Category(2L,"220902","요가", CategoryStatus.ACTIVE)
        ));
        categoryDtoList1 = new ArrayList<>(Arrays.asList(
                new CategoryDto.response("220901","헬스",CategoryStatus.ACTIVE),
                new CategoryDto.response("220902","요가",CategoryStatus.ACTIVE)
        ));
    }

    @Nested
    @DisplayName("success getTitleCategory case")
    class successGetTitleCategoryCase {

        @Test
        @DisplayName("success getTitleCategory test 1 -> getTitle, active false")
        public void successGetTitleCategory1() throws Exception {
            given(categoryRepository.findAll()).willReturn(categoryList);
            given(categoryMapper.categoryListToCategoryDtoResponseList(Mockito.anyList())).willReturn(categoryDtoList);

            List<CategoryDto.response> result = categoryService.getCategoryTitles(false);

            then(categoryRepository).should(times(1))
                    .findAll();
            then(categoryMapper).should(times(1))
                    .categoryListToCategoryDtoResponseList(anyList());
            assertThat(result, equalTo(categoryDtoList));
        }
        @Test
        @DisplayName("success getTitleCategory test 2 -> getTitle, active true")
        public void successGetTitleCategory2() throws Exception {
            given(categoryRepository.findAllByCategoryStatus(Mockito.any(CategoryStatus.class)))
                    .willReturn(categoryList1);
            given(categoryMapper.categoryListToCategoryDtoResponseList(Mockito.anyList()))
                    .willReturn(categoryDtoList1);

            List<CategoryDto.response> result = categoryService.getCategoryTitles(true);

            then(categoryRepository).should(times(1))
                    .findAllByCategoryStatus(Mockito.any(CategoryStatus.class));
            then(categoryMapper).should(times(1))
                    .categoryListToCategoryDtoResponseList(anyList());
            assertThat(result, equalTo(categoryDtoList1));
        }
    }

    @Nested
    @DisplayName("fail getTitleCategory case")
    class failGetTitleCategoryCase {

        @Test
        @DisplayName("fail getTitleCategory test 1 -> null  active false")
        public void failGetTitleCategory1() throws Exception {
            List<CategoryDto.response> result = categoryService.getCategoryTitles(false);

            assertThat(result, equalTo(new ArrayList<>()));
        }
        @Test
        @DisplayName("fail getTitleCategory test 2 -> null  active true")
        public void failGetTitleCategory2() throws Exception {
            List<CategoryDto.response> result = categoryService.getCategoryTitles(true);

            assertThat(result, equalTo(new ArrayList<>()));
        }
    }
}
