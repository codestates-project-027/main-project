package com.minimi.backend.auth.service;

import com.minimi.backend.auth.domain.Auth;
import com.minimi.backend.auth.domain.AuthDTO;
import com.minimi.backend.auth.domain.MemberMapper;
import com.minimi.backend.auth.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public void createMember(AuthDTO.request request) {
        Auth auth = memberRepository.save(memberMapper.authDTORequestToAuth(request));
    }
    public AuthDTO.loginResponse login(AuthDTO.loginRequest request) {
        return null;
    }
}