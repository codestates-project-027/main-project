package com.minimi.backend.comunityTest;

import com.google.gson.Gson;
import com.minimi.backend.community.CommentController;
import com.minimi.backend.community.ContentController;
import com.minimi.backend.community.domain.CommentDTO;
import com.minimi.backend.community.domain.ContentDTO;
import com.minimi.backend.community.service.CommentService;
import com.minimi.backend.community.service.ContentService;
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
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.patch;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CommentController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;
    @MockBean
    private CommentService commentService;

    @Test
    public void postComment() throws Exception {
        CommentDTO.request request = new CommentDTO.request(
                1L, "작성자", "프로필 사진","내용");
        String content = gson.toJson(request);
        ResultActions actions = mockMvc.perform(
                post("/comment")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));
        actions.andExpect(status().isCreated())
                .andDo(document(
                        "post-comment",
                        getRequestPreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("contentId").description("게시글 아이디"),
                                        fieldWithPath("username").description("댓글 작성자"),
                                        fieldWithPath("userProfile").description("프로필 사진"),
                                        fieldWithPath("contents").description("댓글 내용")
                                ))
                ));
    }

//    @Test
//    public void patchReview() throws Exception {
//
//        CommentDTO.patch reviewPatch = new CommentDTO.patch("내용 수정");
//        String content = gson.toJson(reviewPatch);
//        ResultActions actions = mockMvc.perform(
//                patch("/comment/{commentId}", 1L)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content)
//        );
//        actions.andExpect(status().isResetContent())
//                .andDo(document(
//                        "patch-comment",
//                        getRequestPreProcessor(),
//                        pathParameters(
//                                parameterWithName("commentId").description("댓글 아이디")
//                        ),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("contents").description("댓글 내용")
//                                ))
//                ));
//    }

    @Test
    public void deleteComment() throws Exception {
        ResultActions actions = mockMvc.perform(
                delete("/comment/{commentId}", 1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isNoContent())
                .andDo(document(
                        "delete-comment",
                        getRequestPreProcessor(),
                        pathParameters(
                                parameterWithName("commentId").description("댓글 아이디")
                        )));
    }

}
