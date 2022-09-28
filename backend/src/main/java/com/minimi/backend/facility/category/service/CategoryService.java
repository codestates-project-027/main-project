package com.minimi.backend.facility.category.service;

import com.minimi.backend.facility.category.domain.Category;
import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CategoryService {

    void postCategory(CategoryDto.request categoryDtoRequest);

    void patchCategory(String categoryCode, CategoryDto.patch categoryDtoRequest);

    List<CategoryDto.response> getCategoryTitles(Boolean active);

    Slice<ResponseFacilityDto.facilityPageFromCategory> getCategory(String categoryCode, int page);
}
