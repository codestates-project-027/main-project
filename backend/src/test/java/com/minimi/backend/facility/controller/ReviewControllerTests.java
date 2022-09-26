package com.minimi.backend.facility.controller;


import com.google.gson.Gson;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityStatus;
import com.minimi.backend.facility.review.domain.ReviewDto;
import com.minimi.backend.facility.review.controller.ReviewController;
import com.minimi.backend.facility.review.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.minimi.backend.ApiDocumentUtils.getRequestPreProcessor;
import static com.minimi.backend.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ReviewController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class ReviewControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private ReviewService reviewService;

    @Test
    public void postReview() throws Exception{
        ReviewDto.request reviewReq = new ReviewDto.request(1L, "미니미회원","좋은 운동시설이에요!");
        String content = gson.toJson(reviewReq);
        ResultActions actions = mockMvc.perform(
                post("/review")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        actions.andExpect(status().isCreated())
                .andDo(document(
                        "post-review",
                        getRequestPreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("facilityId").description("운동시설 Id"),
                                        fieldWithPath("username").description("리뷰 유저 네임"),
                                        fieldWithPath("contents").description("리뷰 내용")
                                ))
                ));
    }

    @Test
    public void patchReview() throws Exception {
        Long reviewId = 1L;
        ReviewDto.patch reviewPatch = new ReviewDto.patch("미니미", "여기 좋은 운동시설이네요");
        String content = gson.toJson(reviewPatch);
        ResultActions actions = mockMvc.perform(
                patch("/review/{reviewId}", reviewId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        actions.andExpect(status().isResetContent())
                .andDo(document(
                        "patch-review",
                        getRequestPreProcessor(),
                        pathParameters(
                                parameterWithName("reviewId").description("리뷰 ID")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("username").description("리뷰 유저 네임"),
                                        fieldWithPath("contents").description("리뷰 내용")
                                ))
                ));
    }
    @Test
    public void deleteReview() throws Exception{
        Long reviewId = 1L;
        Long facilityId = 1L;
        ResultActions actions = mockMvc.perform(
                delete("/review/{facilityId}/{reviewId}", facilityId, reviewId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isNoContent())
                .andDo(document(
                        "delete-review",
                        getRequestPreProcessor(),
                        pathParameters(
                                parameterWithName("facilityId").description("시설 ID"),
                                parameterWithName("reviewId").description("리뷰 ID")
                        )));
    }


    @Test
    public void getReviewPage() throws Exception {
        Long facilityId = 1L;
        int page = 1;
        List<ReviewDto.response> reviewList = new ArrayList<>(Arrays.asList(
                new ReviewDto.response(
                        1L,"헬린이","userProfileIMG","좋은 헬스장이네요!",LocalDate.of(2022,8,11)),
                new ReviewDto.response(
                        2L,"헬고수","userProfileIMG","그냥 헬스장이네요!",LocalDate.of(2022,9,11)),
                new ReviewDto.response(
                        3L,"사용자","userProfileIMG","헬스장이네요!",LocalDate.of(2022,10,11))
        ));
        Slice<ReviewDto.response> reviewPage = new SliceImpl<>(reviewList, PageRequest.of(page-1, 10), false);


        given(reviewService.getReview(Mockito.anyLong())).willReturn(reviewList);

        ResultActions actions = mockMvc.perform(
                get("/review/{facilityId}", facilityId)
//                        .param("page", String.valueOf(page))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("content[0].reviewId").value(1L))
                .andExpect(jsonPath("pageable.pageNumber").value(page-1))
                .andDo(document(
                        "get-reviewPage",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                                pathParameters(parameterWithName("facilityId").description("조회 운동시설ID")),
                                requestParameters(parameterWithName("page").description("페이지")),
                                responseFields(
                                        List.of(
                                                fieldWithPath("content[].reviewId").type(JsonFieldType.NUMBER).description("리뷰 ID"),
                                                fieldWithPath("content[].username").type(JsonFieldType.STRING).description("리뷰 유저네임"),
                                                fieldWithPath("content[].userProfile").type(JsonFieldType.STRING).description("리뷰 유저 프로필이미지"),
                                                fieldWithPath("content[].contents").type(JsonFieldType.STRING).description("리뷰 본문"),
                                                fieldWithPath("content[].createdAt").type(JsonFieldType.STRING).description("리뷰 생성일"),
                                                fieldWithPath("pageable.sort.sorted").type(JsonFieldType.BOOLEAN).description("pageable sort sorted 정보"),
                                                fieldWithPath("pageable.sort.unsorted").type(JsonFieldType.BOOLEAN).description("pageable sort unsorted 정보"),
                                                fieldWithPath("pageable.sort.empty").type(JsonFieldType.BOOLEAN).description("pageable sort empty 정보"),
                                                fieldWithPath("pageable.pageNumber").type(JsonFieldType.NUMBER).description("pageable 넘버 정보"),
                                                fieldWithPath("pageable.pageSize").type(JsonFieldType.NUMBER).description("pageable 사이즈 정보"),
                                                fieldWithPath("pageable.offset").type(JsonFieldType.NUMBER).description("pageable sort 오프셋 정보"),
                                                fieldWithPath("pageable.paged").type(JsonFieldType.BOOLEAN).description("pageable sort paged 정보"),
                                                fieldWithPath("pageable.unpaged").type(JsonFieldType.BOOLEAN).description("unpaged"),
                                                fieldWithPath("last").type(JsonFieldType.BOOLEAN).description("마지막 페이지"),
                                                fieldWithPath("numberOfElements").type(JsonFieldType.NUMBER).description("numberOfElements"),
                                                fieldWithPath("size").type(JsonFieldType.NUMBER).description("페이지 사이즈"),
                                                fieldWithPath("sort.sorted").type(JsonFieldType.BOOLEAN).description("정렬 sorted 정보"),
                                                fieldWithPath("sort.unsorted").type(JsonFieldType.BOOLEAN).description("정렬 unsorted 정보"),
                                                fieldWithPath("sort.empty").type(JsonFieldType.BOOLEAN).description("정렬 empty 정보"),
                                                fieldWithPath("first").type(JsonFieldType.BOOLEAN).description("첫번째 페이지"),
                                                fieldWithPath("number").type(JsonFieldType.NUMBER).description("number"),
                                                fieldWithPath("empty").type(JsonFieldType.BOOLEAN).description("empty")
                                        )
                                )
                        )
                );
    }
}
