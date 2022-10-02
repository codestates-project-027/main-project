package com.minimi.backend.mypage.miraclescore.sub;


import com.minimi.backend.mypage.dailycheck.pub.MiracleScoreAddEvent;
import com.minimi.backend.mypage.miraclescore.MiracleScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DailyCheckSub {

    private final MiracleScoreService miracleScoreService;

    @EventListener
    public void saveReviewFacility(MiracleScoreAddEvent miracleScoreAddEvent) {
        miracleScoreService.addScore(miracleScoreAddEvent.getUsername());
    }
}
