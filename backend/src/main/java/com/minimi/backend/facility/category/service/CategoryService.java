package com.minimi.backend.facility.category.service;

import com.minimi.backend.facility.category.domain.Category;
import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.facility.domain.facility.FacilityDto;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CategoryService {

    Category postCategory(CategoryDto.request categoryDtoRequest);

    Category patchCategory(String categoryCode, CategoryDto.patch categoryDtoRequest);

    List<CategoryDto.response> getCategoryTitles();

    Slice<FacilityDto.responsePage> getCategory(String categoryCode, int page);
}
