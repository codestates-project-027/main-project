package com.minimi.backend.auth.service;

import com.minimi.backend.auth.domain.Member;
import com.minimi.backend.auth.domain.MemberDTO;
import com.minimi.backend.auth.domain.MemberMapper;
import com.minimi.backend.auth.domain.MemberRepository;
import com.minimi.backend.exception.BusinessLogicException;
import com.minimi.backend.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity createMember(Member member) {
        if (memberRepository.findByEmail(member.getEmail()) == null) {
            member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
            member.setRoles("ROLE_USER");
            memberRepository.save(member);
            return new ResponseEntity<>("회원가입완료", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("email 중복", HttpStatus.BAD_REQUEST);
        }
    }


    @Transactional(readOnly = true)
    public Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember =
                memberRepository.findById(memberId);
        Member findMember =
                optionalMember.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }
}