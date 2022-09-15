package com.minimi.backend.comunityTest;

import com.google.gson.Gson;
import com.minimi.backend.community.ContentController;
import com.minimi.backend.community.domain.ContentDTO;
import com.minimi.backend.community.service.ContentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.minimi.backend.ApiDocumentUtils.getRequestPreProcessor;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.patch;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContentController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class ContentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;
    @MockBean
    private ContentService contentService;
    @Test
    public void postContent() throws Exception{
        ContentDTO.request request = new ContentDTO.request(
                "제목","내용","작성자");
        String content =gson.toJson(request);
        ResultActions actions = mockMvc.perform(
                post("/content")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));
        actions.andExpect(status().isCreated())
                .andDo(document(
                        "post-content",
                        getRequestPreProcessor(),
                        requestFields(
                                List.of(
                                fieldWithPath("title").description("제목"),
                                fieldWithPath("contents").description("내용"),
                                fieldWithPath("username").description("작성자")
                                ))
                ));
    }

    @Test
    public void patchContent() throws Exception {
        ContentDTO.request request = new ContentDTO.request(
                "제목","내용","작성자");

        String content =gson.toJson(request);
        ResultActions actions = mockMvc.perform(
                patch("/content/{contentId}",1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );

        actions.andExpect(status().isResetContent())
                .andDo(document(
                        "patch-content",
                        getRequestPreProcessor(),
                        pathParameters(
                                parameterWithName("contentId").description("게시글번호")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("title").description("제목 수정"),
                                        fieldWithPath("content").description("내용 수정"),
                                        fieldWithPath("username").description("작성자")
                                ))
                ));
    }
    @Test
    public void deleteContent() throws Exception {
        ResultActions actions = mockMvc.perform(
                delete("/content/{contentId}",1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isNoContent())
                .andDo(document(
                        "delete-content",
                        getRequestPreProcessor(),
                        pathParameters(
                                parameterWithName("contentId").description("게시글번호")
                        )));
    }


}
