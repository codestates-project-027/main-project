package com.minimi.backend.comunityTest;

import com.google.gson.Gson;
import com.minimi.backend.community.ContentController;
import com.minimi.backend.community.domain.CommentDTO;
import com.minimi.backend.community.domain.ContentDTO;
import com.minimi.backend.community.service.ContentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.minimi.backend.ApiDocumentUtils.getRequestPreProcessor;
import static com.minimi.backend.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.data.domain.PageRequest.of;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContentController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class ContentControllerTest implements helper {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;
    @MockBean
    private ContentService contentService;

    @Test
    public void postContent() throws Exception {
        ContentDTO.request request = new ContentDTO.request(
                "제목", "내용", "작성자");
        String content = gson.toJson(request);
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
                                        fieldWithPath("title").description("제목 수정"),
                                        fieldWithPath("content").description("내용 수정"),
                                        fieldWithPath("username").description("작성자")
                                ))
                ));
    }

    @Test
    public void patchContent() throws Exception {
        ContentDTO.request request = new ContentDTO.request(
                "제목", "내용", "작성자");

        String content = gson.toJson(request);
        ResultActions actions = mockMvc.perform(
                patch("/content/{contentId}", 1L)
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
                delete("/content/{contentId}", 1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isNoContent())
                .andDo(document(
                        "delete-content",
                        getRequestPreProcessor(),
                        pathParameters(
                                parameterWithName("contentId").description("게시글 아이디")
                        )));
    }

//    @Test
//    public void getContent() throws Exception {
//
//        List<CommentDTO.comment> commentList = new ArrayList<>();
//        commentList.add(new CommentDTO.comment(1L, 1L, "댓글내용", "댓글작성자",
//                LocalDateTime.of(2022, 9, 16, 12, 32,1,1)));
//        commentList.add(new CommentDTO.comment(2L, 1L, "댓글내용2", "댓글작성자2",
//                LocalDateTime.of(2022, 9, 16, 12, 42,1,1)));
//
//        ContentDTO.response response = new ContentDTO.response(1L, "제목", "내용", "작성자",
//                LocalDateTime.of(2022, 9, 16, 12, 30,1,1),
//                "프로필 사진", 0, 0, commentList);
//
//        given(contentService.getContent(Mockito.anyLong())).willReturn(response);
//        ResultActions actions = mockMvc.perform(
//                get("/content/{contentId}", 1L)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//        );
//        actions.andExpect(status().isCreated())
//                .andExpect(jsonPath("contentId").value(response.getContentId()))
//                .andExpect(jsonPath("title").value(response.getTitle()))
//                .andExpect(jsonPath("content").value(response.getContent()))
//                .andExpect(jsonPath("username").value(response.getUsername()))
//                .andExpect(jsonPath("createdAt").value("2022-09-16T12:30:01.000000001"))
//                .andExpect(jsonPath("userProfile").value(response.getUserProfile()))
//                .andExpect(jsonPath("comment[0].commentId").value(1L))
//                .andExpect(jsonPath("comment[0].contentId").value(1L))
//                .andExpect(jsonPath("comment[0].content").value("댓글내용"))
//                .andExpect(jsonPath("comment[0].username").value("댓글작성자"))
//                .andExpect(jsonPath("comment[0].createdAt").value("2022-09-16T12:32:01.000000001"))
//                .andExpect(jsonPath("comment[1].commentId").value(2L))
//                .andExpect(jsonPath("comment[1].contentId").value(1L))
//                .andExpect(jsonPath("comment[1].content").value("댓글내용2"))
//                .andExpect(jsonPath("comment[1].username").value("댓글작성자2"))
//                .andExpect(jsonPath("comment[1].createdAt").value("2022-09-16T12:42:01.000000001"))
//                .andDo(document(
//                        "get-content",
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("contentId").description("게시글 아이디")
//                        ),
//                responseFields(
//                        List.of(
//                                fieldWithPath("contentId").type(JsonFieldType.NUMBER).description("게시글 아이디"),
//                                fieldWithPath("title").type(JsonFieldType.STRING).description("게시글 제목"),
//                                fieldWithPath("content").type(JsonFieldType.STRING).description("게시글 내용"),
//                                fieldWithPath("username").type(JsonFieldType.STRING).description("게시글 작성자"),
//                                fieldWithPath("createdAt").type(JsonFieldType.NUMBER).description("게시글 작성 시간"),
//                                fieldWithPath("userProfile").type(JsonFieldType.STRING).description("작성자 프로필 사진"),
//                                fieldWithPath("views").type(JsonFieldType.NUMBER).description("게시글 작성 시간"),
//                                fieldWithPath("like").type(JsonFieldType.NUMBER).description("작성자 프로필 사진"),
//                                fieldWithPath("comment[0].commentId").type(JsonFieldType.NUMBER).description("게시글 아이디"),
//                                fieldWithPath("comment[0].content").type(JsonFieldType.NUMBER).description("댓글 내용"),
//                                fieldWithPath("comment[0].username").type(JsonFieldType.NUMBER).description("댓글 작성자"),
//                                fieldWithPath("comment[0].createdAt").type(JsonFieldType.NUMBER).description("댓글 작성 시간")
//                        )
//                )
//                ));
//    }
//
//    @Test
//    public void getContents() throws Exception{
//        int page =1;
//        List<ContentDTO.contents> contentList = new ArrayList<>();
//        contentList.add(new ContentDTO.contents(2L,"제목1","작성자1",LocalDateTime.of(2022,9,16,12,21,1,1),0,0));
//        contentList.add(new ContentDTO.contents(3L,"제목2","작성자2",LocalDateTime.of(2022,9,16,12,23),0,0));
//
//        String con = gson.toJson(new ContentDTO.contents(1L,"제목","작성자",LocalDateTime.of(2022,9,16,12,24),0,0));
//        mockMvc.perform(postRequestBuilder(getUrl(), con));
//        MultiValueMap<String,String> queryParam = new LinkedMultiValueMap<>();
//        queryParam.add("page", String.valueOf(1));
//        queryParam.add("size", String.valueOf(10));
//        Slice<ContentDTO.contents> contents = new SliceImpl<>(contentList, PageRequest.of(page-1, 5),false);
//        given(contentService.getContents(Mockito.anyInt(),Mockito.anyInt())).willReturn(contents);
//
//        ResultActions actions = mockMvc.perform(
//                                    get("/content")
//                                         .params(
//                                                  queryParam
//                                           )
//                                         .accept(MediaType.APPLICATION_JSON)
//                                            .contentType(MediaType.APPLICATION_JSON)
//                                            .content(con));
//        MvcResult result = actions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("content[0].contentId").value(2L))
//                .andExpect(jsonPath("content[0].title").value(contentList.get(0).getTitle()))
//                .andExpect(jsonPath("content[0].username").value(contentList.get(0).getUsername()))
//                .andExpect(jsonPath("content[0].createdAt").value("2022-09-16T12:21:01.000000001"))
//                .andDo(
//                        document(
//                                "get-contents",
//                                getRequestPreProcessor(),
//                                getResponsePreProcessor(),
//                                pathParameters(
//                                        parameterWithName("page").description("페이지")),
//                                responseFields(
//                                        List.of(
//                                                fieldWithPath("content[0].contentId").type(JsonFieldType.NUMBER).description("게시글 ID")))))
//                .andReturn();
//
//
//
//
//
//
//
//    }

}

