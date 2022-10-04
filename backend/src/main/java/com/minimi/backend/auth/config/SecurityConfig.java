package com.minimi.backend.auth.config;

import com.minimi.backend.auth.domain.MemberRepository;
import com.minimi.backend.auth.filter.JwtAuthenticationFilter;
import com.minimi.backend.auth.filter.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Autowired
    private final CorsFilter corsFilter;
    private final MemberRepository memberRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();// CSRF 보호 기능 Disable
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//세션 Creation Stateless == 세션 상태 저장 하지않음.
                .and()
                .formLogin().disable()// formLogin 비활성화(JWT 로그인 사용)
                .httpBasic().disable()// 기본 로그인 화면 비활성화
                .apply(new CustomDsl())
                .and()
                .authorizeRequests()//요청에 대한 권한 지정. Security 처리에 HttpServletRequest를 이용한다는 것을 의미한다.
                .antMatchers(HttpMethod.POST,"/question/**","/answer/**","/comment/**","/vote/**")//해당 경로에 대한 접속 권한 설정
                .access("hasRole('ROLE_USER')")//해당 Role을 가지고 있는 사용자만 접근가능
                .antMatchers(HttpMethod.PATCH,"/question/**","/answer/**","/comment/**","/vote/**")//해당 경로에 대한 접속 권한 설정
                .access("hasRole('ROLE_USER')")//해당 Role을 가지고 있는 사용자만 접근가능
                .antMatchers(HttpMethod.DELETE,"/question/**","/answer/**","/comment/**","/vote/**")//해당 경로에 대한 접속 권한 설정
                .access("hasRole('ROLE_USER')")//해당 Role을 가지고 있는 사용자만 접근가능
                .anyRequest()// 설정한 경로 외에 모든 경로를 뜻함
                .permitAll();//어떤 사용자든지 접근 가능

        return http.build();
    }
    public class CustomDsl extends AbstractHttpConfigurer<CustomDsl, HttpSecurity> {

        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
            builder
                    .addFilter(corsFilter)
                    .addFilter(new JwtAuthenticationFilter(authenticationManager))
                    .addFilter(new JwtAuthorizationFilter(authenticationManager, memberRepository));
        }

    }
}
