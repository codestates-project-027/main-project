package com.minimi.backend.facility;


import com.google.gson.Gson;

import com.minimi.backend.facility.domain.FacilityDto;
import com.minimi.backend.facility.domain.Review;
import com.minimi.backend.facility.domain.ReviewDto;
import com.minimi.backend.facility.service.FacilityService;
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

import java.time.LocalDate;
import java.util.ArrayList;
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


@WebMvcTest(FacilityController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class FacilityControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private FacilityService facilityService;

    @Test
    public void getFacility() throws Exception{
        Long facilityId = 1L;
        List<String> facilityPhotoList = new ArrayList<>();
        List<String> categoryList = new ArrayList<>();
        List<ReviewDto.response> reviews = new ArrayList<>();
        facilityPhotoList.add("이미지1");
        facilityPhotoList.add("이미지2");
        categoryList.add("헬스");
        categoryList.add("PT");
        reviews.add(new ReviewDto.response(
                1L,"헬린이","userProfileIMG","좋은 헬스장이네요!",LocalDate.of(2022,8,11)));
        reviews.add(new ReviewDto.response(
                2L,"삼대오백","userProfileIMG","운동기구가 조금 부족해요..",LocalDate.of(2022,8,15)));
        FacilityDto.response facility = new FacilityDto.response(
                1L,
                "미니미헬스장",
                facilityPhotoList,
                "미니미 헬스장입니다",
                "서울특별시 강남구",
                "www.minimi-health.kr",
                "010-0000-0000",
                5,
                "34.123456, 119.123456",
                categoryList,
                "영업중",
                reviews);
        given(facilityService.getFacility(Mockito.anyLong())).willReturn(facility);

        ResultActions actions = mockMvc.perform(
                get("/facility/{facilityId}", facilityId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("facilityId").value(facilityId))
                .andExpect(jsonPath("facilityName").value("미니미헬스장"))
                .andExpect(jsonPath("facilityPhotoList[0]").value("이미지1"))
                .andExpect(jsonPath("facilityPhotoList[1]").value("이미지2"))
                .andExpect(jsonPath("facilityInfo").value("미니미 헬스장입니다"))
                .andExpect(jsonPath("address").value("서울특별시 강남구"))
                .andExpect(jsonPath("website").value("www.minimi-health.kr"))
                .andExpect(jsonPath("phone").value("010-0000-0000"))
                .andExpect(jsonPath("reviewCount").value(5))
                .andExpect(jsonPath("location").value("34.123456, 119.123456"))
                .andExpect(jsonPath("categoryList[0]").value("헬스"))
                .andExpect(jsonPath("categoryList[1]").value("PT"))
                .andExpect(jsonPath("status").value("영업중"))
                .andExpect(jsonPath("reviews[0].reviewId").value(1L))
                .andExpect(jsonPath("reviews[0].user").value("헬린이"))
                .andExpect(jsonPath("reviews[0].userProfile").value("userProfileIMG"))
                .andExpect(jsonPath("reviews[0].contents").value("좋은 헬스장이네요!"))
                .andExpect(jsonPath("reviews[0].createdAt").value(String.valueOf(LocalDate.of(2022,8,11))))
                .andExpect(jsonPath("reviews[1].reviewId").value(2L))
                .andExpect(jsonPath("reviews[1].user").value("삼대오백"))
                .andExpect(jsonPath("reviews[1].userProfile").value("userProfileIMG"))
                .andExpect(jsonPath("reviews[1].contents").value("운동기구가 조금 부족해요.."))
                .andExpect(jsonPath("reviews[1].createdAt").value(String.valueOf(LocalDate.of(2022,8,15))))
                .andDo(document(
                        "get-facility",
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("facilityId").description("운동시설 ID")
                        ),
                        responseFields(
                                fieldWithPath("facilityId").type(JsonFieldType.NUMBER).description("운동시설 ID"),
                                fieldWithPath("facilityName").type(JsonFieldType.STRING).description("운동시설 이름"),
                                fieldWithPath("facilityPhotoList").type(JsonFieldType.ARRAY).description("운동시설 이미지 리스트"),
                                fieldWithPath("facilityInfo").type(JsonFieldType.STRING).description("운동시설 정보"),
                                fieldWithPath("address").type(JsonFieldType.STRING).description("운동시설 주소"),
                                fieldWithPath("website").type(JsonFieldType.STRING).description("운동시설 웹사이트"),
                                fieldWithPath("phone").type(JsonFieldType.STRING).description("운동시설 연락처"),
                                fieldWithPath("reviewCount").type(JsonFieldType.NUMBER).description("운동시설 별점"),
                                fieldWithPath("location").type(JsonFieldType.STRING).description("운동시설 좌표"),
                                fieldWithPath("categoryList").type(JsonFieldType.ARRAY).description("운동시설 카테고리 리스트"),
                                fieldWithPath("status").type(JsonFieldType.STRING).description("운동시설 상태"),
                                fieldWithPath("reviews[0].reviewId").type(JsonFieldType.NUMBER).description("운동시설 리뷰 id"),
                                fieldWithPath("reviews[0].user").type(JsonFieldType.STRING).description("운동시설 리뷰 작성자"),
                                fieldWithPath("reviews[0].userProfile").type(JsonFieldType.STRING).description("운동시설 리뷰 작성자 프로필이미지"),
                                fieldWithPath("reviews[0].contents").type(JsonFieldType.STRING).description("운동시설 리뷰 본문"),
                                fieldWithPath("reviews[0].createdAt").type(JsonFieldType.STRING).description("운동시설 리뷰 생성일"),
                                fieldWithPath("reviews[1].reviewId").type(JsonFieldType.NUMBER).description("운동시설 리뷰 id"),
                                fieldWithPath("reviews[1].user").type(JsonFieldType.STRING).description("운동시설 리뷰 작성자"),
                                fieldWithPath("reviews[1].userProfile").type(JsonFieldType.STRING).description("운동시설 리뷰 작성자 프로필이미지"),
                                fieldWithPath("reviews[1].contents").type(JsonFieldType.STRING).description("운동시설 리뷰 본문"),
                                fieldWithPath("reviews[1].createdAt").type(JsonFieldType.STRING).description("운동시설 리뷰 id")
                                )
                ));
    }

    @Test
    public void postFacility() throws Exception{
        List<String> photoList = new ArrayList<>();
        photoList.add("이미지");
        List<String> categoryList = new ArrayList<>();
        categoryList.add("헬스");
        categoryList.add("PT");
        FacilityDto.request facilityReq = new FacilityDto.request(
                "미니미헬스장",
                "대표이미지",
                photoList,
                "미니미 헬스장 입니다.",
                "서울특별시 강남구",
                "www.minimi-health.kr",
                "010-0000-0000",
                "36.123456, 119.123456",
                categoryList);
        String content = gson.toJson(facilityReq);
        ResultActions actions = mockMvc.perform(
                post("/facility")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        actions.andExpect(status().isCreated())
                .andDo(document(
                        "post-facility",
                        getRequestPreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("facilityName").description("운동시설 이름"),
                                        fieldWithPath("facilityPhoto").description("운동시설 대표이미지"),
                                        fieldWithPath("facilityPhotoList").description("운동시설 이미지 리스트"),
                                        fieldWithPath("facilityInfo").description("운동시설 상세안내"),
                                        fieldWithPath("address").description("운동시설 주소"),
                                        fieldWithPath("website").description("운동시설 웹사이트"),
                                        fieldWithPath("phone").description("운동시설 연락처"),
                                        fieldWithPath("location").description("운동시설 좌표"),
                                        fieldWithPath("categoryList").description("운동시설 카테고리 리스트")
                                ))
                ));
    }



}
