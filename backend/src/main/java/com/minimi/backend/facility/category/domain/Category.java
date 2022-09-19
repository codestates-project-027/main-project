package com.minimi.backend.facility.category.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(unique = true, length = 100, nullable = false)
    private String categoryCode;

    @Column(unique = true, length = 30, nullable = false)
    private String categoryTitle;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryStatus categoryStatus;

    @Builder
    public Category(String categoryTitle, CategoryStatus categoryStatus, String categoryCode){
        this.categoryCode = categoryCode;
        this.categoryTitle = categoryTitle;
        this.categoryStatus = categoryStatus;
    }
}
