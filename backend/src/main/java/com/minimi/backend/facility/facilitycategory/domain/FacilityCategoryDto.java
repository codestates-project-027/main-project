package com.minimi.backend.facility.facilitycategory.domain;

import com.minimi.backend.facility.category.domain.CategoryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

public class FacilityCategoryDto {
    @AllArgsConstructor
    @Getter
    @Builder
    @NoArgsConstructor
    public static class response{
        private Long facilityCategoryId;
        private String categoryCode;
        private String categoryTitle;
    }
}
