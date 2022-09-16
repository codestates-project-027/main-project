package com.minimi.backend.auth;

import com.minimi.backend.auth.domain.AuthDTO;
import com.minimi.backend.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    //login
    @PostMapping("/login")
    private ResponseEntity login(@RequestBody AuthDTO.loginRequest request){
        return new ResponseEntity(request,HttpStatus.OK);
    }


    //join
    @PostMapping("/join")
    private ResponseEntity<AuthDTO.response> createMember(@RequestBody AuthDTO.request request){

        return new ResponseEntity<>(authService.createMember(request),HttpStatus.CREATED);
    }

}
