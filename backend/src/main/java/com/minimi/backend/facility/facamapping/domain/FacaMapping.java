package com.minimi.backend.facility.facamapping.domain;

import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FacaMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faca_mapping_id")
    private Long facaMappingId;

    @Column
    private Long facaId;

    @Column
    private Long faId;

    @ManyToOne
    @JoinColumn(name = "facility_category_id")
    private FacilityCategory facilityCategory;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;


    @Builder
    public FacaMapping(FacilityCategory facilityCategory, Facility facility, Long facilityCategoryId, Long facilityId){
        this.facilityCategory = facilityCategory;
        this.facility = facility;
        this.facaId = facilityCategoryId;
        this.faId = facilityId;
    }
}
