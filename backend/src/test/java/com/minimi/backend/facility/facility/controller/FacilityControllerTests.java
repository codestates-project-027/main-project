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
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockPart;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.multipart.MultipartFile;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
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
        facilityPhotoList.add("?????????1");
        facilityPhotoList.add("?????????2");
        categoryList.add("??????");
        categoryList.add("PT");
        reviews.add(new ReviewDto.response(
                1L,"?????????","?????? ??????????????????!", LocalDateTime.of(2022,8,11,10,20)));
        reviews.add(new ReviewDto.response(
                2L,"????????????","??????????????? ?????? ????????????..",LocalDateTime.of(2022,8,15,10,20)));
        FacilityDto.response facility = new FacilityDto.response(
                1L,
                "??????????????????",
                facilityPhotoList,
                "????????? ??????????????????",
                "??????????????? ?????????",
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
                .andExpect(jsonPath("facilityName").value("??????????????????"))
                .andExpect(jsonPath("facilityPhotoList[0]").value("?????????1"))
                .andExpect(jsonPath("facilityPhotoList[1]").value("?????????2"))
                .andExpect(jsonPath("facilityInfo").value("????????? ??????????????????"))
                .andExpect(jsonPath("address").value("??????????????? ?????????"))
                .andExpect(jsonPath("website").value("www.minimi-health.kr"))
                .andExpect(jsonPath("phone").value("010-0000-0000"))
                .andExpect(jsonPath("starRate").value(5))
                .andExpect(jsonPath("location").value("34.123456, 119.123456"))
                .andExpect(jsonPath("categoryList[0]").value("??????"))
                .andExpect(jsonPath("categoryList[1]").value("PT"))
                .andExpect(jsonPath("facilityStatus").value("ACTIVE"))
                .andExpect(jsonPath("reviews[0].reviewId").value(1L))
                .andExpect(jsonPath("reviews[0].username").value("?????????"))
                .andExpect(jsonPath("reviews[0].contents").value("?????? ??????????????????!"))
                .andExpect(jsonPath("reviews[1].reviewId").value(2L))
                .andExpect(jsonPath("reviews[1].username").value("????????????"))
                .andExpect(jsonPath("reviews[1].contents").value("??????????????? ?????? ????????????.."))
                .andDo(document(
                        "get-facility",
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("facilityId").description("???????????? ID")
                        ),
                        responseFields(
                                fieldWithPath("facilityId").type(JsonFieldType.NUMBER).description("???????????? ID"),
                                fieldWithPath("facilityName").type(JsonFieldType.STRING).description("???????????? ??????"),
                                fieldWithPath("facilityPhotoList").type(JsonFieldType.ARRAY).description("???????????? ????????? ?????????"),
                                fieldWithPath("facilityInfo").type(JsonFieldType.STRING).description("???????????? ??????"),
                                fieldWithPath("address").type(JsonFieldType.STRING).description("???????????? ??????"),
                                fieldWithPath("website").type(JsonFieldType.STRING).description("???????????? ????????????"),
                                fieldWithPath("phone").type(JsonFieldType.STRING).description("???????????? ?????????"),
                                fieldWithPath("starRate").type(JsonFieldType.NUMBER).description("???????????? ??????"),
                                fieldWithPath("location").type(JsonFieldType.STRING).description("???????????? ??????"),
                                fieldWithPath("categoryList").type(JsonFieldType.ARRAY).description("???????????? ???????????? ?????????"),
                                fieldWithPath("facilityStatus").type(JsonFieldType.STRING).description("???????????? ??????"),
                                fieldWithPath("reviews[0].reviewId").type(JsonFieldType.NUMBER).description("???????????? ?????? id"),
                                fieldWithPath("reviews[0].username").type(JsonFieldType.STRING).description("???????????? ?????? ?????????"),
                                fieldWithPath("reviews[0].contents").type(JsonFieldType.STRING).description("???????????? ?????? ??????"),
                                fieldWithPath("reviews[0].createdAt").type(JsonFieldType.STRING).description("???????????? ?????? ?????????"),
                                fieldWithPath("reviews[1].reviewId").type(JsonFieldType.NUMBER).description("???????????? ?????? id"),
                                fieldWithPath("reviews[1].username").type(JsonFieldType.STRING).description("???????????? ?????? ?????????"),
                                fieldWithPath("reviews[1].contents").type(JsonFieldType.STRING).description("???????????? ?????? ??????"),
                                fieldWithPath("reviews[1].createdAt").type(JsonFieldType.STRING).description("???????????? ?????? id")
                                )
                ));
    }

    @Test
    public void postFacility() throws Exception{
        MockMultipartFile multipartFile1 = new MockMultipartFile(
                "minimitest","minimitest.png","image/png",new FileInputStream("src/testimg/minimitest.png"));
        MockMultipartFile multipartFile2 = new MockMultipartFile(
                "file","minimitest.png","application/octet-stream",new byte[0]);

        List<MultipartFile> multipartFileList = new ArrayList<>();
        multipartFileList.add(multipartFile1);
        multipartFileList.add(multipartFile2);
        FacilityDto.request requestDto = new FacilityDto.request(
                "?????????","????????????","??????","www.wwww.www","010-0000-0000","35.123, 199.123",
                new ArrayList<>());
        String requestDtoJson =  gson.toJson(requestDto);
        MockMultipartFile request = new MockMultipartFile("request","request","application/json",requestDtoJson.getBytes(StandardCharsets.UTF_8));


//        List<String> photoList = new ArrayList<>();
//        photoList.add("?????????");
//        List<String> categoryList = new ArrayList<>();
//        categoryList.add("??????");
//        categoryList.add("PT");
//        FacilityDto.request facilityReq = new FacilityDto.request(
//                "??????????????????",
//                "????????? ????????? ?????????.",
//                "??????????????? ?????????",
//                "www.minimi-health.kr",
//                "010-0000-0000",
//                "36.123456, 119.123456",
//                categoryList);
//        String content = gson.toJson(facilityReq);

        ResultActions actions = mockMvc.perform(
                multipart(HttpMethod.POST,"/facility")
                        .file(multipartFile2)
                        .file(request)
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8"));

        actions.andExpect(status().isCreated()).andDo(document(
                        "post-facility",
                        getRequestPreProcessor(),
                        requestParts(
                                partWithName("file").description("upload files"),
                                partWithName("request").description("facilityDto Request")
                        )
                ));
    }
    @Test
    public void patchFacility() throws Exception {
        MockMultipartFile multipartFile1 = new MockMultipartFile(
                "minimitest","minimitest.png","image/png",new FileInputStream("src/testimg/minimitest.png"));
        MockMultipartFile multipartFile2 = new MockMultipartFile(
                "file","minimitest.png","application/octet-stream",new byte[0]);

        List<MultipartFile> multipartFileList = new ArrayList<>();
        multipartFileList.add(multipartFile1);
        multipartFileList.add(multipartFile2);
        FacilityDto.patch facilityReq = new FacilityDto.patch(
                "??????????????????",
                "????????? ????????? ?????????.",
                "??????????????? ?????????",
                "www.minimi-health.kr",
                "010-0000-0000",
                "36.123456, 119.123456",
                new ArrayList<>());
        String requestDtoJson =  gson.toJson(facilityReq);
        MockMultipartFile request = new MockMultipartFile("request","request","application/json",requestDtoJson.getBytes(StandardCharsets.UTF_8));
        Long facilityId = 1L;

        ResultActions actions = mockMvc.perform(
                multipart(HttpMethod.PATCH,"/facility/1")
                        .file(multipartFile2)
                        .file(request)
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")

        );
        actions.andExpect(status().isResetContent()).andDo(document(
                        "patch-facility",
                        getRequestPreProcessor(),
//                        pathParameters(
//                                parameterWithName("facilityId").description("???????????? ID")
//                        ),
                        requestParts(
                                partWithName("file").description("upload files"),
                                partWithName("request").description("facilityDto patch Request")
                        )
                ));
    }
//    private MockMultipartHttpServletRequestBuilder multipartPatchBuilder(final String url, Object... urlVariables){
//        final MockMultipartHttpServletRequestBuilder builder = MockMvcRequestBuilders.multipart(url,urlVariables);
//        builder.with(request1 -> {
//            request1.setMethod(HttpMethod.PATCH.name());
//            return request1;
//        });
//        return builder;
//    }
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
                                parameterWithName("facilityId").description("???????????? ID")
                        )));
    }

    @Test
    public void getNearFacilityList() throws Exception{
        String location = "35.123456, 119.123456";
        int page = 1;
        List<FacilityDto.responsePage> facilityList = new ArrayList<>();
        FacilityDto.responsePage facility = new FacilityDto.responsePage(
                1L,"???????????????","???????????????","??????????????? ?????????",3,"35.123456, 119.123456",
                new ArrayList<>(Arrays.asList("??????")) ,FacilityStatus.ACTIVE);
        FacilityDto.responsePage facility1 = new FacilityDto.responsePage(
                2L,"???????????????","???????????????","??????????????? ?????????",2,"35.123456, 120.123456",
                new ArrayList<>(Arrays.asList("??????","PT")),FacilityStatus.INACTIVE);
        FacilityDto.responsePage facility2 = new FacilityDto.responsePage(
                3L,"??????????????????","???????????????","??????????????? ?????????",5,"35.123456, 119.123456",
                new ArrayList<>(Arrays.asList("??????","??????")),FacilityStatus.ACTIVE);
        facilityList.add(facility);
        facilityList.add(facility1);
        facilityList.add(facility2);
        Slice<FacilityDto.responsePage> facilitySlice = new SliceImpl<>(facilityList, PageRequest.of(page-1, 30),false);
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
                                        parameterWithName("location").description("????????????"),
                                        parameterWithName("page").description("?????????")),
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
