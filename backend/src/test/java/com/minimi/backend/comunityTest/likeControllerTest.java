package com.minimi.backend.comunityTest;

import com.google.gson.Gson;
import com.minimi.backend.community.likes.controller.LikesController;
import com.minimi.backend.community.likes.domain.LikesDTO;
import com.minimi.backend.community.likes.service.LikesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import java.util.List;
import static com.minimi.backend.ApiDocumentUtils.getRequestPreProcessor;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LikesController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class likeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private LikesService likesService;

    @Test
    public void postLike() throws Exception{
        LikesDTO.request request = new LikesDTO.request(1L,"닉네임", Boolean.TRUE);
        String content = gson.toJson(request);
        ResultActions actions = mockMvc.perform(
                post("/likes")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        actions.andExpect(status().isCreated())
                .andDo(document(
                        "post-likes",
                        getRequestPreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("contentId").description("게시글 아이디"),
                                        fieldWithPath("username").description("유저 닉네임"),
                                        fieldWithPath("likes").description("좋아요")
                                ))
                ));
    }
    @Test
    public void deleteLike() throws Exception {
        ResultActions actions = mockMvc.perform(
                delete("/likes/{contentId}",1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isNoContent())
                .andDo(document(
                        "delete-likes",
                        getRequestPreProcessor(),
                        pathParameters(
                                parameterWithName("contentId").description("게시글 아이디")
                        )));
}}
