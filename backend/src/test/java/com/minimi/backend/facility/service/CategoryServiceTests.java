package com.minimi.backend.facility.service;



import com.minimi.backend.facility.category.domain.Category;
import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.category.domain.CategoryRepository;
import com.minimi.backend.facility.category.service.CategoryService;
import com.minimi.backend.facility.category.service.CategoryServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTests {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;
    @Test
    @DisplayName("postCategory Test")
    public void postCategory() throws Exception {
        //given
        Category category = Category.builder()
                .categoryTitle("헬스")
                .categoryStatus("활성")
                .build();
        when(categoryRepository.save(any())).thenReturn(category);

        //when
        CategoryDto.request categoryRequest = new CategoryDto.request("헬스","활성");
        Category result = categoryService.postCategory(categoryRequest);

        //then
        verify(categoryRepository, times(1)).save(any());
        assertThat(result, equalTo(category));

    }
}
