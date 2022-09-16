package com.minimi.backend.facility.service;


import com.minimi.backend.facility.domain.CategoryDto;
import com.minimi.backend.facility.domain.FacilityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    public CategoryDto.response patchCategory(String categoryTitle,CategoryDto.request categoryDtoRequest) {
        return null;
    }

    public List<CategoryDto.responseList> getCategoryTitles() {
        return null;
    }

    public Slice<FacilityDto.responsePage> getCategory(String categoryTitle, int page) {
        return null;
    }
}
