package com.minimi.backend.facility.category.service;

import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.facility.FacilityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Override
    public void postCategory(CategoryDto.request categoryDtoRequest) {
    }
    @Override
    public void patchCategory(String categoryTitle, CategoryDto.request categoryDtoRequest) {
    }
    @Override
    public List<CategoryDto.responseList> getCategoryTitles() {
        return null;
    }

    @Override
    public Slice<FacilityDto.responsePage> getCategory(String categoryTitle, int page) {
        return null;
    }
}
