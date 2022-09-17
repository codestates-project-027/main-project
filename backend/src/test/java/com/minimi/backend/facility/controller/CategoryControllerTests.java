package com.minimi.backend.facility.controller;


import com.google.gson.Gson;
import com.minimi.backend.facility.category.controller.CategoryController;
import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.category.service.CategoryService;
import com.minimi.backend.facility.facility.FacilityDto;
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
import org.springframework.test.web.servlet.ResultActions;

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


@WebMvcTest(CategoryController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class CategoryControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void postCategory() throws Exception{
        CategoryDto.request categoryDtoRequest = new CategoryDto.request("헬스장", "활성");
        String content = gson.toJson(categoryDtoRequest);
        ResultActions actions = mockMvc.perform(
                post("/category")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        actions.andExpect(status().isCreated())
                .andDo(document(
                        "post-category",
                        getRequestPreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("categoryTitle").description("카테고리 이름"),
                                        fieldWithPath("categoryStatus").description("카테고리 상태")))
                ));
    }

    @Test
    public void patchCategory() throws Exception {
        String categoryTitle = "헬스장";
        CategoryDto.request categoryReq = new CategoryDto.request(categoryTitle, "비활성");
        String content = gson.toJson(categoryReq);
        ResultActions actions = mockMvc.perform(
                patch("/category/{categoryTitle}", categoryTitle)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        actions.andExpect(status().isResetContent())
                .andDo(document(
                        "patch-category",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("categoryTitle").description("타겟 카테고리 이름")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("categoryTitle").description("변경할 카테고리 이름"),
                                        fieldWithPath("categoryStatus").description("변경할 카테고리 상태")
                                ))
                ));
    }

    @Test
    public void getCategoryTitles() throws Exception{
        List<CategoryDto.responseList> categoryTitles = new ArrayList<>();
        CategoryDto.responseList category = new CategoryDto.responseList("헬스");
        CategoryDto.responseList category1 = new CategoryDto.responseList("복싱");
        CategoryDto.responseList category2 = new CategoryDto.responseList("요가");
        categoryTitles.add(category);
        categoryTitles.add(category1);
        categoryTitles.add(category2);
        given(categoryService.getCategoryTitles()).willReturn(categoryTitles);
        ResultActions actions = mockMvc.perform(
                get("/category")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("[0].categoryTitle").value("헬스"))
                .andExpect(jsonPath("[1].categoryTitle").value("복싱"))
                .andExpect(jsonPath("[2].categoryTitle").value("요가"))
                .andDo(document(
                        "get-categoryTitles",
                        getResponsePreProcessor(),
                        responseFields(
                                List.of(
                                        fieldWithPath("[].categoryTitle").type(JsonFieldType.STRING).description("카테고리 이름")
                                )
                        )
                ));
    }

    @Test
    public void getCategory() throws Exception{
        String categoryTitle = "헬스";
        int page = 1;
        List<FacilityDto.responsePage> facilityList = new ArrayList<>();
        FacilityDto.responsePage facility = new FacilityDto.responsePage(
                1L,"파워헬스장","대표이미지","서울특별시 강남구",3,"35.123456, 119.123456", "영업중");
        FacilityDto.responsePage facility1 = new FacilityDto.responsePage(
                2L,"종국헬스장","대표이미지","서울특별시 강북구",2,"35.123456, 120.123456", "영업종료");
        FacilityDto.responsePage facility2 = new FacilityDto.responsePage(
                3L,"미니미헬스장","대표이미지","서울특별시 강남구",5,"35.123456, 119.123456", "영업중");
        facilityList.add(facility);
        facilityList.add(facility1);
        facilityList.add(facility2);
        Slice<FacilityDto.responsePage> categorySlice = new SliceImpl<>(facilityList,PageRequest.of(page-1, 5),false);
        given(categoryService.getCategory(Mockito.anyString(),Mockito.anyInt())).willReturn(categorySlice);
        ResultActions actions = mockMvc.perform(
                get("/category/{categoryTitle}", categoryTitle)
                        .param("page", String.valueOf(page))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("content[0].facilityId").value(1L))
                .andExpect(jsonPath("pageable.pageNumber").value(page-1))
                .andDo(
                        document(
                                "get-category",
                                getRequestPreProcessor(),
                                getResponsePreProcessor(),
                                pathParameters(parameterWithName("categoryTitle").description("타겟 카테고리 이름")),
                                requestParameters(parameterWithName("page").description("페이지")),
                                responseFields(
                                        List.of(
                                                fieldWithPath("content[].facilityId").type(JsonFieldType.NUMBER).description("운동시설 ID"),
                                                fieldWithPath("content[].facilityName").type(JsonFieldType.STRING).description("운동시설 이름"),
                                                fieldWithPath("content[].facilityPhoto").type(JsonFieldType.STRING).description("운동시설 대표이미지"),
                                                fieldWithPath("content[].address").type(JsonFieldType.STRING).description("운동시설 주소"),
                                                fieldWithPath("content[].reviewCount").type(JsonFieldType.NUMBER).description("운동시설 별점"),
                                                fieldWithPath("content[].location").type(JsonFieldType.STRING).description("운동시설 좌표"),
                                                fieldWithPath("content[].status").type(JsonFieldType.STRING).description("운동시설 상태"),
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
