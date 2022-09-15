package com.minimi.backend.auth.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AuthDTO {
    private Long id;
    private String email; //id로 사용
    private String username; //nickname으로 사용
    private String password;
    private String userProfile;
    private String role;

    @AllArgsConstructor
    @Getter
    public static class request {
        private String email;
        private String username;
        private String password;
        private String userProfile;
        private String role;
    }
    @Getter
    @AllArgsConstructor
    public static class response {
        @NotBlank
        @Email
        private String email;

        @NotBlank(message = "이름은 공백이 아니어야 합니다.")
        private String username;

        private String userProfile;
    }

}
