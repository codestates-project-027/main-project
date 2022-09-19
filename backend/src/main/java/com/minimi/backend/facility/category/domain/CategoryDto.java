package com.minimi.backend.facility.category.domain;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String categoryCode;
    private String categoryTitle;
    private CategoryStatus categoryStatus;

    @AllArgsConstructor
    @Getter
    public static class request{
        @NotBlank(message = "카테고리 관리코드는 공백일 수 없습니다.")
        @Size(max = 100, message = "카테고리 관리코드가 너무 깁니다.")
        private String categoryCode;

        @NotBlank(message = "카테고리 타이틀은 공백일 수 없습니다.")
        @Size(max = 30, message = "카테고리 타이틀이 너무 깁니다.")
        private String categoryTitle;

        @NotNull(message = "상태코드가 필요합니다")
        private CategoryStatus categoryStatus;
    }

    @AllArgsConstructor
    @Getter
    @Builder
    public static class patch{
        @Size(max = 30, message = "카테고리 타이틀이 너무 깁니다.")
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
