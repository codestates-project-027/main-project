package com.minimi.backend.facility.facility.domain.facilitycategorylist;

import com.minimi.backend.facility.facility.domain.facility.Facility;
import com.minimi.backend.facility.facility.domain.facilitycategory.FacilityCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
