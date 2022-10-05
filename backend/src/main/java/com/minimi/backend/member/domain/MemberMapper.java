package com.minimi.backend.member.domain;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member authDTORequestToAuth(MemberDTO.request request);
}
