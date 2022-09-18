package com.minimi.backend.facility.category.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column
    private String categoryCode;

    @Column
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
