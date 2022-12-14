package com.minimi.backend.facility.review.controller;


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
import java.time.LocalDateTime;
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
        ReviewDto.request reviewReq = new ReviewDto.request(1L, "???????????????","?????? ?????????????????????!");
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
                                        fieldWithPath("facilityId").description("???????????? Id"),
                                        fieldWithPath("username").description("?????? ?????? ??????"),
                                        fieldWithPath("contents").description("?????? ??????")
                                ))
                ));
    }

    @Test
    public void patchReview() throws Exception {
        Long reviewId = 1L;
        Long facilityId = 1L;
        ReviewDto.patch reviewPatch = new ReviewDto.patch("?????????", "?????? ?????? ?????????????????????");
        String content = gson.toJson(reviewPatch);
        ResultActions actions = mockMvc.perform(
                patch("/review/{facilityId}/{reviewId}", facilityId, reviewId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        actions.andExpect(status().isResetContent())
                .andDo(document(
                        "patch-review",
                        getRequestPreProcessor(),
                        pathParameters(
                                parameterWithName("facilityId").description("?????? ID"),
                                parameterWithName("reviewId").description("?????? ID")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("username").description("?????? ?????? ??????"),
                                        fieldWithPath("contents").description("?????? ??????")
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
                                parameterWithName("facilityId").description("?????? ID"),
                                parameterWithName("reviewId").description("?????? ID")
                        )));
    }


    @Test
    public void getReviewPage() throws Exception {
        Long facilityId = 1L;
        int page = 1;
        List<ReviewDto.response> reviewList = new ArrayList<>(Arrays.asList(
                new ReviewDto.response(
                        1L,"?????????","?????? ??????????????????!", LocalDateTime.of(2022,8,11,10,20)),
                new ReviewDto.response(
                        2L,"?????????","?????? ??????????????????!",LocalDateTime.of(2022,9,11,10,20)),
                new ReviewDto.response(
                        3L,"?????????","??????????????????!",LocalDateTime.of(2022,10,11,10,20))
        ));

//        Slice<ReviewDto.response> reviewPage = new SliceImpl<>(reviewList, PageRequest.of(page-1, 10), false);


        given(reviewService.getReview(Mockito.anyLong())).willReturn(reviewList);

        ResultActions actions = mockMvc.perform(
                get("/review/{facilityId}", facilityId)
                        .param("page", String.valueOf(page))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isOk())
//                .andExpect(jsonPath("content[0].reviewId").value(1L))
                .andDo(document(
                        "get-reviewPage",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                                pathParameters(parameterWithName("facilityId").description("?????? ????????????ID")),
                                requestParameters(parameterWithName("page").description("?????????")),
                                responseFields(
                                        List.of(
                                                fieldWithPath("[].reviewId").type(JsonFieldType.NUMBER).description("?????? ID"),
                                                fieldWithPath("[].username").type(JsonFieldType.STRING).description("?????? ????????????"),
                                                fieldWithPath("[].contents").type(JsonFieldType.STRING).description("?????? ??????"),
                                                fieldWithPath("[].createdAt").type(JsonFieldType.STRING).description("?????? ?????????")
//                                                fieldWithPath("content[].reviewId").type(JsonFieldType.NUMBER).description("?????? ID"),
//                                                fieldWithPath("content[].username").type(JsonFieldType.STRING).description("?????? ????????????"),
//                                                fieldWithPath("content[].userProfile").type(JsonFieldType.STRING).description("?????? ?????? ??????????????????"),
//                                                fieldWithPath("content[].contents").type(JsonFieldType.STRING).description("?????? ??????"),
//                                                fieldWithPath("content[].createdAt").type(JsonFieldType.STRING).description("?????? ?????????"),
//                                                fieldWithPath("pageable.sort.sorted").type(JsonFieldType.BOOLEAN).description("pageable sort sorted ??????"),
//                                                fieldWithPath("pageable.sort.unsorted").type(JsonFieldType.BOOLEAN).description("pageable sort unsorted ??????"),
//                                                fieldWithPath("pageable.sort.empty").type(JsonFieldType.BOOLEAN).description("pageable sort empty ??????"),
//                                                fieldWithPath("pageable.pageNumber").type(JsonFieldType.NUMBER).description("pageable ?????? ??????"),
//                                                fieldWithPath("pageable.pageSize").type(JsonFieldType.NUMBER).description("pageable ????????? ??????"),
//                                                fieldWithPath("pageable.offset").type(JsonFieldType.NUMBER).description("pageable sort ????????? ??????"),
//                                                fieldWithPath("pageable.paged").type(JsonFieldType.BOOLEAN).description("pageable sort paged ??????"),
//                                                fieldWithPath("pageable.unpaged").type(JsonFieldType.BOOLEAN).description("unpaged"),
//                                                fieldWithPath("last").type(JsonFieldType.BOOLEAN).description("????????? ?????????"),
//                                                fieldWithPath("numberOfElements").type(JsonFieldType.NUMBER).description("numberOfElements"),
//                                                fieldWithPath("size").type(JsonFieldType.NUMBER).description("????????? ?????????"),
//                                                fieldWithPath("sort.sorted").type(JsonFieldType.BOOLEAN).description("?????? sorted ??????"),
//                                                fieldWithPath("sort.unsorted").type(JsonFieldType.BOOLEAN).description("?????? unsorted ??????"),
//                                                fieldWithPath("sort.empty").type(JsonFieldType.BOOLEAN).description("?????? empty ??????"),
//                                                fieldWithPath("first").type(JsonFieldType.BOOLEAN).description("????????? ?????????"),
//                                                fieldWithPath("number").type(JsonFieldType.NUMBER).description("number"),
//                                                fieldWithPath("empty").type(JsonFieldType.BOOLEAN).description("empty")
                                        )
                                )
                        )
                );
    }
}
