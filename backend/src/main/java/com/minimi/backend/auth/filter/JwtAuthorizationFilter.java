package com.minimi.backend.auth.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minimi.backend.auth.domain.Member;
import com.minimi.backend.auth.domain.MemberRepository;
import com.minimi.backend.auth.principal.PrincipalDetails;
import io.jsonwebtoken.UnsupportedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private MemberRepository memberRepository;

    private final ObjectMapper objectMapper =new ObjectMapper();


    private final Logger log = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, MemberRepository memberRepository) {
        super(authenticationManager);
        this.memberRepository = memberRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
       // try {
            System.out.println("인증이나 권한이 필요한 주소 요청 됨.");

            String jwtHeader = request.getHeader("Authorization");
            if (jwtHeader == null || !jwtHeader.startsWith("Bearer")) {
                chain.doFilter(request, response);
                return;
            }
            String jwtToken = jwtHeader.replace("Bearer ", "");//토큰 디코딩
            String email = JWT.require(Algorithm.HMAC512("cos_jwt_token")).build().verify(jwtToken).getClaim("email").asString();//email에 토큰의 소유권 부여

            if (email != null) {
                Member memberEntity = memberRepository.findByEmail(email);
                PrincipalDetails principalDetails = new PrincipalDetails(memberEntity);
                Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities());
                //SecurityContextHolder 에 Authentication 를 세팅하기 때문에 @PreAuthorize 로 권한 파악가능
                SecurityContextHolder.getContext().setAuthentication(authentication);

                chain.doFilter(request, response);
                return;
            }

            super.doFilterInternal(request, response, chain);

//        }catch (JWTDecodeException e) {
//            sendErrorResponse(response, "손상된 토큰입니다");
//        } catch (TokenExpiredException e) {
//            sendErrorResponse(response, "만료된 토큰입니다");
//        } catch (UnsupportedJwtException e) {
//            sendErrorResponse(response, "지원하지 않는 토큰입니다");
//        } catch (SignatureVerificationException e) {
//            sendErrorResponse(response, "시그니처 검증에 실패한 토큰입니다");
//        } catch (Exception e) {
//            sendErrorResponse(response, "알 수 없는 에러입니다");
//        }


//    }
//    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
//        response.setCharacterEncoding("utf-8");
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.getWriter().write(objectMapper.writeValueAsString(Response.builder()
//                .status(HttpStatus.UNAUTHORIZED.value())
//                .message(message)
//                .build()));
//    }
        }
    }