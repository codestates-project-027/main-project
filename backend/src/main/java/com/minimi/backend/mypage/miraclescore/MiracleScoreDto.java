package com.minimi.backend.mypage.miraclescore;


import lombok.AllArgsConstructor;
import lombok.Getter;

public class MiracleScoreDto {
    @AllArgsConstructor
    @Getter
    public static class response {
        private String username;
        private int score;
    }
}
