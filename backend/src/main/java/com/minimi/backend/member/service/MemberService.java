package com.minimi.backend.member.service;

import com.minimi.backend.auth.utils.CustomAuthorityUtils;
import com.minimi.backend.event.MemberRegistrationApplicationEvent;
import com.minimi.backend.member.domain.Member;
import com.minimi.backend.member.domain.MemberDTO;
import com.minimi.backend.member.domain.MemberRepository;
import com.minimi.backend.exception.BusinessLogicException;
import com.minimi.backend.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher publisher;
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;
    public MemberService(MemberRepository memberRepository,

                         ApplicationEventPublisher publisher,
                         PasswordEncoder passwordEncoder,
                         CustomAuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.publisher = publisher;
        this.passwordEncoder = passwordEncoder;
        this.authorityUtils = authorityUtils;
    }
    public Member createMember(Member request) {
        verifyExistsEmail(request.getEmail());

        // (3) 추가: Password 암호화
        String encryptedPassword = passwordEncoder.encode(request.getPassword());
        request.setPassword(encryptedPassword);

        // (4) 추가: DB에 User Role 저장
        List<String> roles = authorityUtils.createRoles(request.getEmail());
        request.setRoles(roles);
        Member savedMember = memberRepository.save(request);
        publisher.publishEvent(new MemberRegistrationApplicationEvent(savedMember));
        return savedMember;
    }
    public MemberDTO.loginResponse login(MemberDTO.loginRequest request) {
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public Member updateMember(MemberDTO.patch member, Long memberId) {
        Member findMember = findVerifiedMember(memberId);

        Optional.ofNullable(member.getUsername())
                .ifPresent(username -> findMember.setUsername(username));
        Optional.ofNullable(member.getPassword())
                .ifPresent(password -> findMember.setPassword(password));
        Optional.ofNullable(member.getUserProfile())
                .ifPresent(userprofile -> findMember.setUserProfile(userprofile));

        return memberRepository.save(findMember);
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
    private void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);

    }
}
