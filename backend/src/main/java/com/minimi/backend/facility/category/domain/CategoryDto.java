package com.minimi.backend.facility.category.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class CategoryDto {

    @AllArgsConstructor
    @Getter
    public static class request{
        private String categoryCode;
        private String categoryTitle;
        private CategoryStatus categoryStatus;
    }

    @AllArgsConstructor
    @Getter
    @Builder
    public static class patch{
        private String categoryTitle;
        private CategoryStatus categoryStatus;
    }

    @AllArgsConstructor
    @Getter
    public static class response{
        private String categoryCode;
        private String categoryTitle;
        private CategoryStatus categoryStatus;
    }
}
