package com.minimi.backend.facility.category.service.publisher;

import lombok.Getter;

@Getter
public class CategoryPatchEvent{
    private final String categoryCode;
    private final String categoryTitle;

    public CategoryPatchEvent(String categoryCode, String categoryTitle) {
        this.categoryCode = categoryCode;
        this.categoryTitle = categoryTitle;
    }
}
