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

    @Column(unique = true)
    private String categoryCode;

    @Column(unique = true)
    private String categoryTitle;

    @Column
    private String categoryStatus;

    @Builder
    public Category(String categoryTitle, String categoryStatus, String categoryCode){
        this.categoryCode = categoryCode;
        this.categoryTitle = categoryTitle;
        this.categoryStatus = categoryStatus;
    }
}
