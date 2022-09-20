package com.minimi.backend.facility.category.service;

import com.minimi.backend.facility.category.domain.Category;
import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.category.domain.CategoryRepository;
import com.minimi.backend.facility.category.mapper.CategoryMapper;
import com.minimi.backend.facility.category.service.listener.CategoryFacilityGetListener;
import com.minimi.backend.facility.category.service.publisher.CategoryPostEvent;
import com.minimi.backend.facility.facility.domain.facility.FacilityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryFacilityGetListener categoryFacilityGetListener;
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public Category postCategory(CategoryDto.request categoryDtoRequest) {

        checkTitle(categoryDtoRequest.getCategoryTitle());
        checkCode(categoryDtoRequest.getCategoryCode());

        Category category = categoryRepository.save(Category
                .builder()
                .categoryTitle(categoryDtoRequest.getCategoryTitle())
                .categoryCode(categoryDtoRequest.getCategoryCode())
                .categoryStatus(categoryDtoRequest.getCategoryStatus())
                .build());

        eventPublisher.publishEvent(new CategoryPostEvent(categoryDtoRequest.getCategoryCode()));
        return category;
    }

    @Override
    public Category patchCategory(String categoryCode, CategoryDto.patch categoryDtoPatch) {

        Category category = getCategory(categoryCode);

        if(!category.getCategoryTitle().equals(categoryDtoPatch.getCategoryTitle())){
            checkTitle(categoryDtoPatch.getCategoryTitle());
        }
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
    public Slice<FacilityDto.responsePage> getCategory(String categoryCode, int page) {
        return categoryFacilityGetListener.getCategory(categoryCode, page);
    }

    public Category getCategory(String categoryCode) {
        if (categoryRepository.existsByCategoryCode(categoryCode)){
            return categoryRepository.findByCategoryCode(categoryCode);
        }
        throw new NullPointerException("Not Found Category");
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
