package com.minimi.backend.facility.category.mapper;

import com.minimi.backend.facility.category.domain.Category;
import com.minimi.backend.facility.category.domain.CategoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    List<CategoryDto.response> categoryListToCategoryDtoResponseList(List<Category> categoryList);
}
