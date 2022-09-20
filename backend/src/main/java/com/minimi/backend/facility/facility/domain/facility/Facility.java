package com.minimi.backend.facility.facility.domain.facility;

import com.minimi.backend.facility.review.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facility_id")
    private Long facilityId;

    @Column
    private String facilityName;

    @Column
    private String facilityPhoto;

    @ElementCollection
    private List<String> facilityPhotoList;

    @Column
    private String facilityInfo;

    @Column
    private String address;

    @Column
    private String website;

    @Column
    private String phone;

    @Column
    private String location;

    @Column
    private int starRate;

    @ElementCollection
    private List<String> categoryList;

    @Column
    private String status;


}
