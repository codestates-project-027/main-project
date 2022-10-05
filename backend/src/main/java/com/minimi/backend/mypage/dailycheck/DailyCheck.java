package com.minimi.backend.mypage.dailycheck;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;



@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DailyCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long dailyCheckId;

    @Column(unique = true)
    private String username;

    @Column
    private String dailyUpdate;

    @Convert(converter = DailyCheckListConverter.class)
    @Column
    private List<String> checkDailyList;

    @Builder
    public DailyCheck(String username, List<String> checkDailyList, String dailyUpdate){
        this.username = username;
        this.checkDailyList = checkDailyList;
        this.dailyUpdate = dailyUpdate;
    }
}
