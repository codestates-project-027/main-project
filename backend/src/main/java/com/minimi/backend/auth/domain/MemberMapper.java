package com.minimi.backend.auth.domain;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member authDTORequestToAuth(MemberDTO.request request);
}
