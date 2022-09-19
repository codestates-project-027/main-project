package com.minimi.backend.facility.category.service;

import com.minimi.backend.facility.category.domain.Category;
import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.category.domain.CategoryRepository;
import com.minimi.backend.facility.category.mapper.CategoryMapper;
import com.minimi.backend.facility.facility.FacilityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
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

        checkTitle(categoryDtoRequest.getCategoryTitle());
        checkCode(categoryDtoRequest.getCategoryCode());

        Category category = Category.builder()
                .categoryTitle(categoryDtoRequest.getCategoryTitle())
                .categoryCode(categoryDtoRequest.getCategoryCode())
                .categoryStatus(categoryDtoRequest.getCategoryStatus())
                .build();
        return categoryRepository.save(category);
    }

    @Override
    public Category patchCategory(String categoryCode, CategoryDto.patch categoryDtoPatch) {
        Category category = categoryRepository.findByCategoryCode(categoryCode)
                .orElseThrow(() -> new NullPointerException("NoContent CategoryCode"));
        checkTitle(categoryDtoPatch.getCategoryTitle());
        if(!(categoryDtoPatch.getCategoryTitle()==null||categoryDtoPatch.getCategoryTitle().isBlank())){
            category.setCategoryTitle(categoryDtoPatch.getCategoryTitle());
        }
        if(!(categoryDtoPatch.getCategoryStatus()==null)){
            category.setCategoryStatus(categoryDtoPatch.getCategoryStatus());
        }
        return categoryRepository.save(category);
    }

    @Override
    public List<CategoryDto.response> getCategoryTitles() {
        return categoryMapper.categoryListToCategoryDtoResponseList(categoryRepository.findAll());
    }

    @Override
    public Slice<FacilityDto.responsePage> getCategory(String categoryTitle, int page) {
        return categoryFacilityGetListener.getCategory(categoryTitle, page);
    }

    public String checkTitle(String categoryTitle) {
        if (categoryRepository.existsByCategoryTitle(categoryTitle)){
            throw new RuntimeException("Exists CategoryTitle");
        }
        return "NotExistsTitle";
    }
    public String checkCode(String categoryCode) {
        if (categoryRepository.existsByCategoryCode(categoryCode)){
            throw new RuntimeException("Exists CategoryCode");
        }
        return "NotExistsCode";
    }
}
