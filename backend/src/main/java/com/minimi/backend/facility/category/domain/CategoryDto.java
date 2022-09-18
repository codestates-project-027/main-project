package com.minimi.backend.facility.category.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class CategoryDto {

    @AllArgsConstructor
    @Getter
    public static class request{
        private String categoryTitle;
        private String categoryStatus;
    }

    @AllArgsConstructor
    @Getter
    public static class response{
        private String categoryCode;
        private String categoryTitle;
        private String categoryStatus;
    }
}
