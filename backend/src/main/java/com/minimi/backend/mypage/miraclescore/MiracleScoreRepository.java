package com.minimi.backend.mypage.miraclescore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MiracleScoreRepository extends JpaRepository<MiracleScore, Long> {

    MiracleScore findByUsername(String username);

    Boolean existsByUsername(String username);
}
