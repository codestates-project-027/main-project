package com.minimi.backend.facility.category.service;

import com.minimi.backend.facility.category.domain.Category;
import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.category.domain.CategoryRepository;
import com.minimi.backend.facility.category.mapper.CategoryMapper;
import com.minimi.backend.facility.facility.FacilityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryFacilityGetListener categoryFacilityGetListener;
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Category postCategory(CategoryDto.request categoryDtoRequest) {
        return null;
    }

    @Override
    public Category patchCategory(String categoryCode, CategoryDto.request categoryDtoRequest) {
        return null;
    }

    @Override
    public List<CategoryDto.response> getCategoryTitles() {
        return null;
    }

    @Override
    public Slice<FacilityDto.responsePage> getCategory(String categoryTitle, int page) {
        return categoryFacilityGetListener.getCategory(categoryTitle, page);
    }
}
