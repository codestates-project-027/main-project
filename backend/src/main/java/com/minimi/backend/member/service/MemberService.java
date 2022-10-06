package com.minimi.backend.member.service;

import com.minimi.backend.auth.utils.CustomAuthorityUtils;
import com.minimi.backend.member.domain.Member;
import com.minimi.backend.member.domain.MemberDTO;
import com.minimi.backend.member.domain.MemberRepository;
import com.minimi.backend.exception.BusinessLogicException;
import com.minimi.backend.exception.ExceptionCode;
import org.springframework.context.ApplicationEventPublisher;
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
        verifyExistsEmail(request.getEmail(),request.getUsername());
        String encryptedPassword = passwordEncoder.encode(request.getPassword());
        request.setPassword(encryptedPassword);
        List<String> roles = authorityUtils.createRoles(request.getEmail());
        request.setRoles(roles);
        Member savedMember = memberRepository.save(request);

        return savedMember;
    }


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public Member updateMember(MemberDTO.patch member, Long memberId) {
        Member findMember = findVerifiedMember(memberId);

        Optional.ofNullable(member.getUsername())
                .ifPresent(username -> findMember.setUsername(username));
        Optional.ofNullable(member.getPassword())
                .ifPresent(password -> findMember.setPassword(password));

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
    private void verifyExistsEmail(String email, String username) {
        if (memberRepository.existsByEmail(email)) throw new BusinessLogicException(ExceptionCode.EMAIL_EXISTS);
        if (memberRepository.existsByUsername(username)) throw new BusinessLogicException(ExceptionCode.USERNAME_EXISTS);
    }

}
