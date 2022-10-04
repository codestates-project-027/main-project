package com.minimi.backend.auth.controller;

import com.minimi.backend.auth.domain.Member;
import com.minimi.backend.auth.domain.MemberDTO;
import com.minimi.backend.auth.domain.MemberRepository;
import com.minimi.backend.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    //login
    @PostMapping("/login")
    public String login() {
        return "로그인 완료";
    }

    @PostMapping("/join")
    public ResponseEntity join(@Valid @RequestBody Member member) {

        return authService.createMember(member);
    }
    //join
    @PatchMapping("/patchmember")
    private ResponseEntity patchMember(@RequestBody MemberDTO.request request){

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
