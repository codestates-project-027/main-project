package com.minimi.backend.facility.facilitycategory.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FacilityCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facility_category_id")
    private Long facilityCategoryId;

    @Column
    private String categoryCode;

    @Column
    private String categoryTitle;


    @Builder
    public FacilityCategory(String categoryCode, String categoryTitle){
        this.categoryCode = categoryCode;
        this.categoryTitle = categoryTitle;
    }
}
