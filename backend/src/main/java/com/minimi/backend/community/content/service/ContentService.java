package com.minimi.backend.community.content.service;

import com.minimi.backend.community.content.domain.ContentDTO;
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
