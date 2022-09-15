package com.minimi.backend.community.service;

import com.minimi.backend.auth.domain.AuthDTO;
import com.minimi.backend.community.domain.ContentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentService {
    public static ContentDTO.response createContent(ContentDTO.request request) {
        return null;
    }
}
