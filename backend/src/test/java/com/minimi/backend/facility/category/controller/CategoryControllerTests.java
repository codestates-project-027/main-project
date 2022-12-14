package com.minimi.backend.facility.category.controller;


import com.google.gson.Gson;
import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.category.domain.CategoryStatus;
import com.minimi.backend.facility.category.service.CategoryService;
import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityStatus;
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
        CategoryDto.request categoryDtoRequest = new CategoryDto.request("220901","?????????", CategoryStatus.ACTIVE);
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
                                        fieldWithPath("categoryCode").description("???????????? ??????"),
                                        fieldWithPath("categoryTitle").description("???????????? ??????"),
                                        fieldWithPath("categoryStatus").description("???????????? ??????")))
                ));
    }

    @Test
    public void patchCategory() throws Exception {
        String categoryTitle = "??????";
        String categoryCode = "220901";
        CategoryDto.patch categoryReq = new CategoryDto.patch(categoryTitle, CategoryStatus.INACTIVE);
        String content = gson.toJson(categoryReq);
        ResultActions actions = mockMvc.perform(
                patch("/category/{categoryCode}", categoryCode)
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
                                parameterWithName("categoryCode").description("?????? ???????????? ??????")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("categoryTitle").description("????????? ???????????? ??????"),
                                        fieldWithPath("categoryStatus").description("????????? ???????????? ??????")
                                ))
                ));
    }

    @Test
    public void getCategoryTitles() throws Exception{
        List<CategoryDto.response> categoryTitles = new ArrayList<>();
        CategoryDto.response category = new CategoryDto.response("220811","??????", CategoryStatus.ACTIVE);
        CategoryDto.response category1 = new CategoryDto.response("220901","??????",CategoryStatus.INACTIVE);
        categoryTitles.add(category);
        categoryTitles.add(category1);
        given(categoryService.getCategoryTitles(Mockito.anyBoolean())).willReturn(categoryTitles);
        ResultActions actions = mockMvc.perform(
                get("/category")
                        .param("active",String.valueOf(false))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("[0].categoryCode").value("220811"))
                .andExpect(jsonPath("[0].categoryTitle").value("??????"))
                .andExpect(jsonPath("[0].categoryStatus").value("ACTIVE"))
                .andExpect(jsonPath("[1].categoryCode").value("220901"))
                .andExpect(jsonPath("[1].categoryTitle").value("??????"))
                .andExpect(jsonPath("[1].categoryStatus").value("INACTIVE"))
                .andDo(document(
                        "get-categoryTitles",
                        getResponsePreProcessor(),
                        responseFields(
                                List.of(
                                        fieldWithPath("[].categoryCode").type(JsonFieldType.STRING).description("???????????? ??????"),
                                        fieldWithPath("[].categoryTitle").type(JsonFieldType.STRING).description("???????????? ??????"),
                                        fieldWithPath("[].categoryStatus").type(JsonFieldType.STRING).description("???????????? ??????")
                                )
                        )
                ));
    }

    @Test
    public void getCategory() throws Exception{
        String categoryCode = "220901";
        int page = 1;
        List<ResponseFacilityDto.facilityPageFromCategory> facilityList = new ArrayList<>();
        ResponseFacilityDto.facilityPageFromCategory facility = new ResponseFacilityDto.facilityPageFromCategory(
                1L,"???????????????","???????????????","??????????????? ?????????",3,"35.123456, 119.123456",
                new ArrayList<>(Arrays.asList("??????")), FacilityStatus.ACTIVE);
        ResponseFacilityDto.facilityPageFromCategory facility1 = new ResponseFacilityDto.facilityPageFromCategory(
                2L,"???????????????","???????????????","??????????????? ?????????",2,"35.123456, 120.123456",
                new ArrayList<>(Arrays.asList("??????", "PT")),FacilityStatus.INACTIVE);
        ResponseFacilityDto.facilityPageFromCategory facility2 = new ResponseFacilityDto.facilityPageFromCategory(
                3L,"??????????????????","???????????????","??????????????? ?????????",5,"35.123456, 119.123456",
                new ArrayList<>(Arrays.asList("??????", "??????")),FacilityStatus.ACTIVE);
        facilityList.add(facility);
        facilityList.add(facility1);
        facilityList.add(facility2);
        Slice<ResponseFacilityDto.facilityPageFromCategory> categorySlice = new SliceImpl<>(facilityList,PageRequest.of(page-1, 10),false);
        given(categoryService.getCategory(Mockito.anyString(),Mockito.anyInt())).willReturn(categorySlice);
        ResultActions actions = mockMvc.perform(
                get("/category/{categoryCode}", categoryCode)
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
                                pathParameters(parameterWithName("categoryCode").description("?????? ???????????? ??????")),
                                requestParameters(parameterWithName("page").description("?????????")),
                                responseFields(
                                        List.of(
                                                fieldWithPath("content[].facilityId").type(JsonFieldType.NUMBER).description("???????????? ID"),
                                                fieldWithPath("content[].facilityName").type(JsonFieldType.STRING).description("???????????? ??????"),
                                                fieldWithPath("content[].facilityPhoto").type(JsonFieldType.STRING).description("???????????? ???????????????"),
                                                fieldWithPath("content[].address").type(JsonFieldType.STRING).description("???????????? ??????"),
                                                fieldWithPath("content[].starRate").type(JsonFieldType.NUMBER).description("???????????? ??????"),
                                                fieldWithPath("content[].location").type(JsonFieldType.STRING).description("???????????? ??????"),
                                                fieldWithPath("content[].categoryList").type(JsonFieldType.ARRAY).description("???????????? ?????????"),
                                                fieldWithPath("content[].facilityStatus").type(JsonFieldType.STRING).description("???????????? ??????"),
                                                fieldWithPath("pageable.sort.sorted").type(JsonFieldType.BOOLEAN).description("pageable sort sorted ??????"),
                                                fieldWithPath("pageable.sort.unsorted").type(JsonFieldType.BOOLEAN).description("pageable sort unsorted ??????"),
                                                fieldWithPath("pageable.sort.empty").type(JsonFieldType.BOOLEAN).description("pageable sort empty ??????"),
                                                fieldWithPath("pageable.pageNumber").type(JsonFieldType.NUMBER).description("pageable ?????? ??????"),
                                                fieldWithPath("pageable.pageSize").type(JsonFieldType.NUMBER).description("pageable ????????? ??????"),
                                                fieldWithPath("pageable.offset").type(JsonFieldType.NUMBER).description("pageable sort ????????? ??????"),
                                                fieldWithPath("pageable.paged").type(JsonFieldType.BOOLEAN).description("pageable sort paged ??????"),
                                                fieldWithPath("pageable.unpaged").type(JsonFieldType.BOOLEAN).description("unpaged"),
                                                fieldWithPath("last").type(JsonFieldType.BOOLEAN).description("????????? ?????????"),
                                                fieldWithPath("numberOfElements").type(JsonFieldType.NUMBER).description("numberOfElements"),
                                                fieldWithPath("size").type(JsonFieldType.NUMBER).description("????????? ?????????"),
                                                fieldWithPath("sort.sorted").type(JsonFieldType.BOOLEAN).description("?????? sorted ??????"),
                                                fieldWithPath("sort.unsorted").type(JsonFieldType.BOOLEAN).description("?????? unsorted ??????"),
                                                fieldWithPath("sort.empty").type(JsonFieldType.BOOLEAN).description("?????? empty ??????"),
                                                fieldWithPath("first").type(JsonFieldType.BOOLEAN).description("????????? ?????????"),
                                                fieldWithPath("number").type(JsonFieldType.NUMBER).description("number"),
                                                fieldWithPath("empty").type(JsonFieldType.BOOLEAN).description("empty")
                                        )
                                )
                        )
                );
    }
}
