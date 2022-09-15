package com.minimi.backend.auth.service;

import com.minimi.backend.auth.domain.AuthDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    public AuthDTO.response createMember(AuthDTO.request request) {
        return null;
    }
    public AuthDTO.loginResponse login(AuthDTO.loginRequest request) {
        return null;
    }
}