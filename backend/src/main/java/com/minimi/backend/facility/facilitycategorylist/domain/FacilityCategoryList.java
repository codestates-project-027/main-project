package com.minimi.backend.facility.facilitycategorylist.domain;

import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "facility_categorylist")
public class FacilityCategoryList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facility_category_list_id")
    private Long facilityCategoryListId;

    @ManyToOne
    @JoinColumn(name = "facility_category_id")
    private FacilityCategory facilityCategory;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;


    @Builder
    public FacilityCategoryList(FacilityCategory facilityCategory, Facility facility){
        this.facilityCategory = facilityCategory;
        this.facility = facility;
    }
}
