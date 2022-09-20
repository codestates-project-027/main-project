package com.minimi.backend.facility.category.service.publisher;

import lombok.Getter;

@Getter
public class CategoryPostEvent{
    private final String categoryCode;

    public CategoryPostEvent(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
