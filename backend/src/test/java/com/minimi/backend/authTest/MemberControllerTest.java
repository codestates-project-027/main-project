//package com.minimi.backend.authTest;
//
//
//import com.google.gson.Gson;
//import com.minimi.backend.auth.controller.AuthController;
//import com.minimi.backend.auth.domain.MemberDTO;
//import com.minimi.backend.auth.service.AuthService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.util.List;
//
//import static com.minimi.backend.ApiDocumentUtils.getRequestPreProcessor;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(AuthController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//public class MemberControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private Gson gson;
//
//    @MockBean
//    private AuthService authService;
//
//    @Test
//    void postMemberTest() throws Exception {
//        // given
//        MemberDTO.request request= new MemberDTO.request("hgd@gmail.com",
//                "hgd","abc1234","image");
//        String content = gson.toJson(request);
//
//        // when
//        ResultActions actions =
//                mockMvc.perform(
//                        post("/join")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//
//         actions.andExpect(status().isCreated())
//                .andDo(document(
//                        "post-member",
//                        getRequestPreProcessor(),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("email").description("이메일"),
//                                        fieldWithPath("username").description("회원 닉네임"),
//                                        fieldWithPath("password").description("비밀번호"),
//                                        fieldWithPath("userProfile").description("프로필 사진")))
//
//
//                ));
//    }
//    @Test
//    void postLoginTest() throws Exception {
//
//        MemberDTO.loginRequest request = new MemberDTO.loginRequest("hgd@gmail.com","abc1234");
//
//        String content = gson.toJson(request);
//        ResultActions actions =
//                mockMvc.perform(
//                        post("/login")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//
//        actions.andExpect(status().isOk())
//                .andDo(document(
//                        "post-login",
//                        getRequestPreProcessor(),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("email").description("이메일"),
//                                        fieldWithPath("password").description("비밀번호")))
//
//                ));
//    }
//
//}
