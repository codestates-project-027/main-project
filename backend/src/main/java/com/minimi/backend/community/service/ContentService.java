package com.minimi.backend.community.service;

import com.minimi.backend.community.domain.ContentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentService {

    public ContentDTO.response getContent(long contentId) {
        return null;
    }
    public Slice<ContentDTO.contents> getContents(int page, int size){
        return null;
    }
}
