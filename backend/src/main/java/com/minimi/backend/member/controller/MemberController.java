package com.minimi.backend.member.controller;

import com.minimi.backend.member.domain.Member;
import com.minimi.backend.member.domain.MemberDTO;
import com.minimi.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    @PostMapping("/join")
    public ResponseEntity join(@Valid @RequestBody Member member) {

        memberService.createMember(member);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/patchmember/{memberId}")
    private ResponseEntity patchMember(@PathVariable Long memberId, @RequestBody MemberDTO.patch member){
        memberService.updateMember(member, memberId);
        return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
    }
}
