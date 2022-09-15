package com.minimi.backend.authTest;


import com.google.gson.Gson;
import com.minimi.backend.auth.AuthController;
import com.minimi.backend.auth.domain.AuthDTO;
import com.minimi.backend.auth.service.AuthService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.minimi.backend.ApiDocumentUtils.getRequestPreProcessor;
import static com.minimi.backend.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;

    @MockBean
    private AuthService authService;

    @Test
    void postMemberTest() throws Exception {
        // given
        AuthDTO.request request= new AuthDTO.request("hgd@gmail.com",
                "hgd","abc1234","image");
        String content = gson.toJson(request);
        AuthDTO.response response= new AuthDTO.response(
                "hgd@gmail.com","hgd","image");
        given(authService.createMember(Mockito.any(AuthDTO.request.class))).willReturn(response);
        // when
        ResultActions actions =
                mockMvc.perform(
                        post("/join")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

         actions.andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value(request.getEmail()))
                .andExpect(jsonPath("$.username").value(request.getUsername()))
                .andExpect(jsonPath("$.userProfile").value(request.getUserProfile()))
                .andDo(document(
                        "post-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("email").description("이메일"),
                                        fieldWithPath("username").description("회원 닉네임"),
                                        fieldWithPath("password").description("비밀번호"),
                                        fieldWithPath("userProfile").description("프로필 사진"))),
                        responseFields(
                                List.of(
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("username").type(JsonFieldType.STRING).description("회원 닉네임"),
                                        fieldWithPath("userProfile").type(JsonFieldType.STRING).description("프로필 사진")))

                ));
    }
    @Test
    void postLoginTest() throws Exception {

        AuthDTO.loginRequest request = new AuthDTO.loginRequest("hgd@gmail.com","abc1234");

        String content = gson.toJson(request);
        AuthDTO.loginResponse response= new AuthDTO.loginResponse("hgd@gmail.com","abc1234","hgd","image","role_user");
        given(authService.login(Mockito.any(AuthDTO.loginRequest.class))).willReturn(response);

        ResultActions actions =
                mockMvc.perform(
                        post("/login")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value(request.getEmail()))
                .andExpect(jsonPath("$.password").value(request.getPassword()))
                .andDo(document(
                        "post-login",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("email").description("이메일"),
                                        fieldWithPath("password").description("비밀번호"))),
                        responseFields(
                                List.of(
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호"),
                                        fieldWithPath("username").type(JsonFieldType.STRING).description("회원 닉네임"),
                                        fieldWithPath("userProfile").type(JsonFieldType.STRING).description("프로필 사진"),
                                        fieldWithPath("role").type(JsonFieldType.STRING).description("권한")))
                ));
    }

}
