package com.minimi.backend.community.contents.mapper;

import com.minimi.backend.community.contents.domain.Contents;
import com.minimi.backend.community.contents.domain.ContentsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContentsMapper {

    Contents contentsDTOToContents(ContentsDTO contentsDTO);
    Contents contentsDTOPatchToContents(ContentsDTO.patch patch);

    ContentsDTO.request contentsToContentsRequest(Contents contents);
    ContentsDTO.response contentsToContentsResponse(Contents contents);
    ContentsDTO.get contentsToContentsGet(Contents contents);
}
