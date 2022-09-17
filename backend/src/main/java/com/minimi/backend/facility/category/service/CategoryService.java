package com.minimi.backend.facility.category.service;

import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.facility.FacilityDto;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CategoryService {

    void postCategory(CategoryDto.request categoryDtoRequest);
    void patchCategory(String categoryTitle, CategoryDto.request categoryDtoRequest);
    List<CategoryDto.responseList> getCategoryTitles();
    Slice<FacilityDto.responsePage> getCategory(String categoryTitle, int page);
}
