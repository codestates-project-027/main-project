package com.minimi.backend.comunityTest;

import com.google.gson.Gson;
import com.minimi.backend.community.contents.controller.ContentsController;
import com.minimi.backend.community.comment.domain.CommentDTO;
import com.minimi.backend.community.contents.domain.ContentsDTO;
import com.minimi.backend.community.contents.service.ContentsService;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.minimi.backend.ApiDocumentUtils.getRequestPreProcessor;
import static com.minimi.backend.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.data.domain.PageRequest.of;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContentsController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class ContentsControllerTest{

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;
    @MockBean
    private ContentsService contentsService;

    @Test
    public void postContents() throws Exception {
        ContentsDTO.request request = new ContentsDTO.request(
                "제목", "내용", "작성자");
        String content = gson.toJson(request);
        ResultActions actions = mockMvc.perform(
                post("/contents")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));
        actions.andExpect(status().isCreated())
                .andDo(document(
                        "post-contents",
                        getRequestPreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("title").description("제목 수정"),
                                        fieldWithPath("contents").description("내용 수정"),
                                        fieldWithPath("username").description("작성자")
                                ))
                ));
    }

    @Test
    public void patchContents() throws Exception {
        ContentsDTO.patch patch = new ContentsDTO.patch(
                "제목", "내용");
        String content = gson.toJson(patch);
        ResultActions actions = mockMvc.perform(
                patch("/contents/{contentsId}", 1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        actions.andExpect(status().isResetContent())
                .andDo(document(
                        "patch-contents",
                        getRequestPreProcessor(),
                        pathParameters(
                                parameterWithName("contentsId").description("게시글번호")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("title").description("제목 수정"),
                                        fieldWithPath("contents").description("내용 수정")
                                ))
                ));
    }

    @Test
    public void deleteContents() throws Exception {
        ResultActions actions = mockMvc.perform(
                delete("/contents/{contentsId}", 1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isNoContent())
                .andDo(document(
                        "delete-contents",
                        getRequestPreProcessor(),
                        pathParameters(
                                parameterWithName("contentsId").description("게시글 아이디")
                        )));
    }

    @Test
    public void getContent() throws Exception {

        List<CommentDTO.comment> commentList = new ArrayList<>();
        commentList.add(new CommentDTO.comment(1L, 1L, "댓글내용", "댓글작성자",
                LocalDateTime.of(2022, 9, 16, 12, 32,1,1)));
        commentList.add(new CommentDTO.comment(2L, 1L, "댓글내용2", "댓글작성자2",
                LocalDateTime.of(2022, 9, 16, 12, 42,1,1)));

        ContentsDTO.response response = new ContentsDTO.response(1L, "제목", "내용", "작성자",
                LocalDateTime.of(2022, 9, 16, 12, 30,1,1),
                "프로필 사진", 0, 0, commentList);

        given(contentsService.getContents(Mockito.anyLong())).willReturn(response);
        ResultActions actions = mockMvc.perform(
                get("/contents/test/{contentsId}", 1L)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath("contentsId").value(response.getContentsId()))
                .andExpect(jsonPath("title").value(response.getTitle()))
                .andExpect(jsonPath("contents").value(response.getContents()))
                .andExpect(jsonPath("username").value(response.getUsername()))
                .andExpect(jsonPath("createdAt").value("2022-09-16T12:30:01.000000001"))
                .andExpect(jsonPath("userProfile").value(response.getUserProfile()))
                .andExpect(jsonPath("comment[0].commentId").value(1L))
                .andExpect(jsonPath("comment[0].contentsId").value(1L))
                .andExpect(jsonPath("comment[0].content").value("댓글내용"))
                .andExpect(jsonPath("comment[0].username").value("댓글작성자"))
                .andExpect(jsonPath("comment[0].createdAt").value("2022-09-16T12:32:01.000000001"))
                .andExpect(jsonPath("comment[1].commentId").value(2L))
                .andExpect(jsonPath("comment[1].contentsId").value(1L))
                .andExpect(jsonPath("comment[1].content").value("댓글내용2"))
                .andExpect(jsonPath("comment[1].username").value("댓글작성자2"))
                .andExpect(jsonPath("comment[1].createdAt").value("2022-09-16T12:42:01.000000001"))
                .andDo(document(
                        "get-contents",
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("contentsId").description("게시글 아이디")
                        ),
                responseFields(
                        List.of(
                                fieldWithPath("contentsId").type(JsonFieldType.NUMBER).description("게시글 아이디"),
                                fieldWithPath("title").type(JsonFieldType.STRING).description("게시글 제목"),
                                fieldWithPath("contents").type(JsonFieldType.STRING).description("게시글 내용"),
                                fieldWithPath("username").type(JsonFieldType.STRING).description("게시글 작성자"),
                                fieldWithPath("createdAt").type(JsonFieldType.STRING).description("게시글 작성 시간"),
                                fieldWithPath("userProfile").type(JsonFieldType.STRING).description("작성자 프로필 사진"),
                                fieldWithPath("views").type(JsonFieldType.NUMBER).description("게시글 작성 시간"),
                                fieldWithPath("likes").type(JsonFieldType.NUMBER).description("작성자 프로필 사진"),
                                fieldWithPath("comment[0].commentId").type(JsonFieldType.NUMBER).description("게시글 아이디"),
                                fieldWithPath("comment[0].contentsId").type(JsonFieldType.NUMBER).description("게시글 아이디"),
                                fieldWithPath("comment[0].content").type(JsonFieldType.STRING).description("댓글 내용"),
                                fieldWithPath("comment[0].username").type(JsonFieldType.STRING).description("댓글 작성자"),
                                fieldWithPath("comment[0].createdAt").type(JsonFieldType.STRING).description("댓글 작성 시간")
                        )
                )
                ));
    }

//    @Test
//    public void getContentsList() throws Exception{
//        int page =1;
//        List<ContentsDTO.contents> contentsList = new ArrayList<>();
//        contentsList.add(new ContentsDTO.contents(2L,"제목1","작성자1",LocalDateTime.of(2022,9,16,12,21,1,1),0,0));
//        contentsList.add(new ContentsDTO.contents(3L,"제목2","작성자2",LocalDateTime.of(2022,9,16,12,23),0,0));
//
//        String con = gson.toJson(new ContentsDTO.contents(1L,"제목","작성자",LocalDateTime.of(2022,9,16,12,24),0,0));
//        mockMvc.perform(postRequestBuilder(getUrl(), con));
//        MultiValueMap<String,String> queryParam = new LinkedMultiValueMap<>();
//        queryParam.add("page", String.valueOf(1));
//        queryParam.add("size", String.valueOf(10));
//        Slice<ContentsDTO.contents> content = new SliceImpl<>(contentList, PageRequest.of(page-1, 5),false);
//        given(contentService.getContents(Mockito.anyInt(),Mockito.anyInt())).willReturn(content);
//
//        ResultActions actions = mockMvc.perform(
//                                    get("/contents")
//                                         .params(
//                                                  queryParam
//                                           )
//                                         .accept(MediaType.APPLICATION_JSON)
//                                            .contentType(MediaType.APPLICATION_JSON)
//                                            .content(con));
//        MvcResult result = actions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("content[0].contentsId").value(2L))
//                .andExpect(jsonPath("content[0].title").value(contentsList.get(0).getTitle()))
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

