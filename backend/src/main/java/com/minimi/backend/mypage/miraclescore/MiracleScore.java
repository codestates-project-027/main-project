package com.minimi.backend.mypage.miraclescore;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MiracleScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long miracleScoreId;

    @Column(unique = true)
    private String username;

    @Column
    private int score;

    @Builder
    public MiracleScore(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public void addMiracleScore(){
        this.score++;
    }
}
