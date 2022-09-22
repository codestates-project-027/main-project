package com.minimi.backend.facility.facility.controller;


import com.google.gson.Gson;

import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityStatus;
import com.minimi.backend.facility.review.domain.ReviewDto;
import com.minimi.backend.facility.facility.service.FacilityServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
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


@WebMvcTest(FacilityController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class FacilityControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private FacilityServiceImpl facilityServiceImpl;

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
                FacilityStatus.ACTIVE,
                reviews);
        given(facilityServiceImpl.getFacility(Mockito.anyLong())).willReturn(facility);

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
                .andExpect(jsonPath("starRate").value(5))
                .andExpect(jsonPath("location").value("34.123456, 119.123456"))
                .andExpect(jsonPath("categoryList[0]").value("헬스"))
                .andExpect(jsonPath("categoryList[1]").value("PT"))
                .andExpect(jsonPath("facilityStatus").value("ACTIVE"))
                .andExpect(jsonPath("reviews[0].reviewId").value(1L))
                .andExpect(jsonPath("reviews[0].username").value("헬린이"))
                .andExpect(jsonPath("reviews[0].userProfile").value("userProfileIMG"))
                .andExpect(jsonPath("reviews[0].contents").value("좋은 헬스장이네요!"))
                .andExpect(jsonPath("reviews[0].createdAt").value(String.valueOf(LocalDate.of(2022,8,11))))
                .andExpect(jsonPath("reviews[1].reviewId").value(2L))
                .andExpect(jsonPath("reviews[1].username").value("삼대오백"))
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
                                fieldWithPath("starRate").type(JsonFieldType.NUMBER).description("운동시설 별점"),
                                fieldWithPath("location").type(JsonFieldType.STRING).description("운동시설 좌표"),
                                fieldWithPath("categoryList").type(JsonFieldType.ARRAY).description("운동시설 카테고리 리스트"),
                                fieldWithPath("facilityStatus").type(JsonFieldType.STRING).description("운동시설 상태"),
                                fieldWithPath("reviews[0].reviewId").type(JsonFieldType.NUMBER).description("운동시설 리뷰 id"),
                                fieldWithPath("reviews[0].username").type(JsonFieldType.STRING).description("운동시설 리뷰 작성자"),
                                fieldWithPath("reviews[0].userProfile").type(JsonFieldType.STRING).description("운동시설 리뷰 작성자 프로필이미지"),
                                fieldWithPath("reviews[0].contents").type(JsonFieldType.STRING).description("운동시설 리뷰 본문"),
                                fieldWithPath("reviews[0].createdAt").type(JsonFieldType.STRING).description("운동시설 리뷰 생성일"),
                                fieldWithPath("reviews[1].reviewId").type(JsonFieldType.NUMBER).description("운동시설 리뷰 id"),
                                fieldWithPath("reviews[1].username").type(JsonFieldType.STRING).description("운동시설 리뷰 작성자"),
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
    @Test
    public void patchFacility() throws Exception {
        Long facilityId = 1L;
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
                patch("/facility/{facilityId}",facilityId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        actions.andExpect(status().isResetContent())
                .andDo(document(
                        "patch-facility",
                        getRequestPreProcessor(),
                        pathParameters(
                                parameterWithName("facilityId").description("운동시설 ID")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("facilityName").description("(Optional)운동시설 이름"),
                                        fieldWithPath("facilityPhoto").description("(Optional)운동시설 대표이미지"),
                                        fieldWithPath("facilityPhotoList").description("(Optional)운동시설 이미지 리스트"),
                                        fieldWithPath("facilityInfo").description("(Optional)운동시설 상세안내"),
                                        fieldWithPath("address").description("(Optional)운동시설 주소"),
                                        fieldWithPath("website").description("(Optional)운동시설 웹사이트"),
                                        fieldWithPath("phone").description("(Optional)운동시설 연락처"),
                                        fieldWithPath("location").description("(Optional)운동시설 좌표"),
                                        fieldWithPath("categoryList").description("(Optional)운동시설 카테고리 리스트")
                                ))
                ));
    }
    @Test
    public void deleteFacility() throws Exception {
        Long facilityId = 1L;
        ResultActions actions = mockMvc.perform(
                delete("/facility/{facilityId}",facilityId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isNoContent())
                .andDo(document(
                        "delete-facility",
                        getRequestPreProcessor(),
                        pathParameters(
                                parameterWithName("facilityId").description("운동시설 ID")
                        )));
    }

    @Test
    public void getNearFacilityList() throws Exception{
        String location = "35.123456, 119.123456";
        int page = 1;
        List<ResponseFacilityDto.facilityPageFromCategory> facilityList = new ArrayList<>();
        ResponseFacilityDto.facilityPageFromCategory facility = new ResponseFacilityDto.facilityPageFromCategory(
                1L,"파워헬스장","대표이미지","서울특별시 강남구",3,"35.123456, 119.123456",
                new ArrayList<>(Arrays.asList("헬스")) ,FacilityStatus.ACTIVE);
        ResponseFacilityDto.facilityPageFromCategory facility1 = new ResponseFacilityDto.facilityPageFromCategory(
                2L,"종국헬스장","대표이미지","서울특별시 강북구",2,"35.123456, 120.123456",
                new ArrayList<>(Arrays.asList("헬스","PT")),FacilityStatus.INACTIVE);
        ResponseFacilityDto.facilityPageFromCategory facility2 = new ResponseFacilityDto.facilityPageFromCategory(
                3L,"미니미헬스장","대표이미지","서울특별시 강남구",5,"35.123456, 119.123456",
                new ArrayList<>(Arrays.asList("헬스","요가")),FacilityStatus.ACTIVE);
        facilityList.add(facility);
        facilityList.add(facility1);
        facilityList.add(facility2);
        Slice<ResponseFacilityDto.facilityPageFromCategory> facilitySlice = new SliceImpl<>(facilityList, PageRequest.of(page-1, 5),false);
        given(facilityServiceImpl.getNearFacilityList(Mockito.anyString(),Mockito.anyInt())).willReturn(facilitySlice);
        ResultActions actions = mockMvc.perform(
                get("/facility")
                        .param("location", location)
                        .param("page", String.valueOf(page))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("content[0].facilityId").value(1L))
                .andExpect(jsonPath("pageable.pageNumber").value(page-1))
                .andDo(
                        document(
                                "get-nearFacility",
                                getRequestPreProcessor(),
                                getResponsePreProcessor(),
                                requestParameters(
                                        parameterWithName("location").description("현재좌표"),
                                        parameterWithName("page").description("페이지")),
                                responseFields(
                                        List.of(
                                                fieldWithPath("content[].facilityId").type(JsonFieldType.NUMBER).description("운동시설 ID"),
                                                fieldWithPath("content[].facilityName").type(JsonFieldType.STRING).description("운동시설 이름"),
                                                fieldWithPath("content[].facilityPhoto").type(JsonFieldType.STRING).description("운동시설 대표이미지"),
                                                fieldWithPath("content[].address").type(JsonFieldType.STRING).description("운동시설 주소"),
                                                fieldWithPath("content[].starRate").type(JsonFieldType.NUMBER).description("운동시설 별점"),
                                                fieldWithPath("content[].location").type(JsonFieldType.STRING).description("운동시설 좌표"),
                                                fieldWithPath("content[].categoryList").type(JsonFieldType.ARRAY).description("카테고리 리스트"),
                                                fieldWithPath("content[].facilityStatus").type(JsonFieldType.STRING).description("운동시설 상태"),
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
