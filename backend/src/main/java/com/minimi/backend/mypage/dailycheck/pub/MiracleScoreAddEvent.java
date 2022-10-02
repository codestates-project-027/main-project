package com.minimi.backend.mypage.dailycheck.pub;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MiracleScoreAddEvent {
    private final String username;

    public MiracleScoreAddEvent(String username) {
        this.username = username;
    }
}
