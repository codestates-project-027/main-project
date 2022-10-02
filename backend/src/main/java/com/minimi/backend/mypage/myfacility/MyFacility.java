package com.minimi.backend.mypage.myfacility;


import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MyFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long myFacilityId;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "auth_id")
    @Column(unique = true)
    private String username;

    @Convert(converter = FacilityIdListConverter.class)
    @Column
    private List<String> facilityIdList;


    @Builder
    public MyFacility(String username, List<String> facilityIdList){
        this.username = username;
        this.facilityIdList = facilityIdList;
    }
}

