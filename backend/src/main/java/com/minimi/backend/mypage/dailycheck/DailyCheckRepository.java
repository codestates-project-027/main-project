package com.minimi.backend.mypage.dailycheck;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyCheckRepository extends JpaRepository<DailyCheck, Long> {

    DailyCheck findByUsername(String username);
    Boolean existsByUsername(String username);
}
