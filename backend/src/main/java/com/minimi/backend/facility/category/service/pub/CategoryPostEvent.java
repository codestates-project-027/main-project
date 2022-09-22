package com.minimi.backend.facility.category.service.pub;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryPostEvent{
    private final String categoryCode;
    private final String categoryTitle;

    public CategoryPostEvent(String categoryCode, String categoryTitle) {
        this.categoryCode = categoryCode;
        this.categoryTitle = categoryTitle;
    }
}
