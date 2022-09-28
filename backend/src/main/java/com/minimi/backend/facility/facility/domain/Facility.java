package com.minimi.backend.facility.facility.domain;

import com.minimi.backend.facility.facility.mapper.FacilityCategoryListConverter;
import lombok.*;

import javax.persistence.*;
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


    //todo location객체 만들어서  String 대신 쓰기 (원시타입지양) 변화에 유연하게 만들기
    @Column
    private String location;


    //todo 삭제 (starRate객체 생성 후 dto에 주입)
    @Column
    private int starRate;

    @Convert(converter = FacilityCategoryListConverter.class)
    @Column
    private List<String> categoryList;

    @Column
    @Enumerated(EnumType.STRING)
    private FacilityStatus facilityStatus;

    @Builder
    public Facility(String facilityName, List<String> facilityPhotoList,
                    String facilityInfo, String address, String website, String phone,
                    String location, List<String> categoryList){
        this.facilityName=facilityName;
        this.facilityPhotoList=facilityPhotoList;
        this.facilityInfo=facilityInfo;
        this.address=address;
        this.website=website;
        this.phone=phone;
        this.location=location;
        this.categoryList=categoryList;
        this.starRate=0;
        this.facilityStatus=FacilityStatus.PENDING;
    }


}
