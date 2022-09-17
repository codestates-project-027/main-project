package com.minimi.backend.facility.category;

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
        private String categoryTitle;
        private String categoryStatus;
    }

    @AllArgsConstructor
    @Getter
    public static class responseList{
        private String categoryTitle;
    }
}
