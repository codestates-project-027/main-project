package com.minimi.backend.auth.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Auth {
    private Long id;
    private String email; //id로 사용
    private String username; //nickname으로 사용
    private String password;
    private String userProfile;
    private String role;

//    @Builder
//    public Auth(String email, String username, String password, String role){
//        this.email=email;
//        this.username=username;
//        this.password=password;
//        this.role=role;
//    }
}
