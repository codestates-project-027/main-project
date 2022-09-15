package com.minimi.backend.facility;


import com.google.gson.Gson;
import com.minimi.backend.facility.domain.ReviewDto;
import com.minimi.backend.facility.service.CategoryService;
import com.minimi.backend.facility.service.ReviewService;
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
        ReviewDto.request reviewReq = new ReviewDto.request(1L, "미니미회원","프로필이미지","좋은 운동시설이에요!");
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
                                        fieldWithPath("user").description("리뷰 유저 네임"),
                                        fieldWithPath("userProfile").description("리뷰 유저 프로필"),
                                        fieldWithPath("contents").description("리뷰 내용")
                                ))
                ));
    }
}
