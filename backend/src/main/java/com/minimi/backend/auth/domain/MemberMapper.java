package com.minimi.backend.auth.domain;

import com.minimi.backend.community.contents.domain.Contents;
import com.minimi.backend.community.contents.domain.ContentsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Auth authDTORequestToAuth(AuthDTO.request request);
}
