package com.minimi.backend.community.contents.service;

import com.minimi.backend.community.contents.domain.ContentsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentsService {

    public ContentsDTO.response getContents(long contentsId) {
        return null;
    }
    public Slice<ContentsDTO.contents> getContentsList(int page, int size){
        return null;
    }
}
