package com.minimi.backend.facility.facilitycategory.domain;

import com.minimi.backend.facility.category.domain.CategoryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class FacilityCategoryDto {
    @AllArgsConstructor
    @Getter
    public static class response{
        private String categoryCode;
        private String categoryTitle;
        private CategoryStatus categoryStatus;
    }
}
