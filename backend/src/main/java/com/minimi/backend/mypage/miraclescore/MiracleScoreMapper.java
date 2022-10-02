package com.minimi.backend.mypage.miraclescore;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MiracleScoreMapper {

    MiracleScoreDto.response miracleScoreToMiracleScoreDtoRes(MiracleScore miracleScore);
}
