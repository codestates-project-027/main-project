package com.minimi.backend.mypage.miraclescore;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MiracleScoreService {

    private final MiracleScoreRepository miracleScoreRepository;
    private final MiracleScoreMapper miracleScoreMapper;

    public MiracleScoreDto.response getScore(String username) {
        if (!miracleScoreRepository.existsByUsername(username)){
            createScore(username);
        }

        return miracleScoreMapper.miracleScoreToMiracleScoreDtoRes(
                miracleScoreRepository.findByUsername(username));
    }

    public void addScore(String username){
        if (!miracleScoreRepository.existsByUsername(username)){
            createScore(username);
        }

        MiracleScore miracleScore = miracleScoreRepository.findByUsername(username);
        miracleScore.addMiracleScore();
        miracleScoreRepository.save(miracleScore);
    }

    private void createScore(String username){
        miracleScoreRepository.save(new MiracleScore(username, 0));
    }
}
