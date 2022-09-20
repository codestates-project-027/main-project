package com.minimi.backend.mypage;

import com.google.gson.Gson;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityStatus;
import com.minimi.backend.mypage.myFacility.MyFacilityController;
import com.minimi.backend.mypage.myFacility.MyFacilityDto;
import com.minimi.backend.mypage.myFacility.MyFacilityService;
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

import java.util.ArrayList;
import java.util.List;

import static com.minimi.backend.ApiDocumentUtils.getRequestPreProcessor;
import static com.minimi.backend.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MyFacilityController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class MyFacilityControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private MyFacilityService myFacilityService;

    @Test
    public void postMyFacility() throws Exception{
        MyFacilityDto.request myFacilityReq = new MyFacilityDto.request("미니미회원", 1L);
        String content = gson.toJson(myFacilityReq);
        ResultActions actions = mockMvc.perform(
                post("/myfacility")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        actions.andExpect(status().isCreated())
                .andDo(document(
                        "post-myfacility",
                        getRequestPreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("username").description("유저 닉네임"),
                                        fieldWithPath("facilityId").description("나의 시설 ID")
                                ))
                ));
    }
    @Test
    public void deleteMyFacility() throws Exception {
        Long facilityId = 1L;
        ResultActions actions = mockMvc.perform(
                delete("/myfacility/{facilityId}",facilityId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isNoContent())
                .andDo(document(
                        "delete-myfacility",
                        getRequestPreProcessor(),
                        pathParameters(
                                parameterWithName("facilityId").description("취소 시설 ID")
                        )));
    }

    @Test
    public void getMyFacilitys() throws Exception {
        String username = "MiniMiUser";
        List<FacilityDto.responseMyFacility> facilityList = new ArrayList<>();
        FacilityDto.responseMyFacility facility = new FacilityDto.responseMyFacility(
                1L,"집근처GYM","34.12345, 199.12345", FacilityStatus.ACTIVE);
        FacilityDto.responseMyFacility facility1 = new FacilityDto.responseMyFacility(
                2L,"요가와필라테스", "35.12345, 199.12345", FacilityStatus.ACTIVE);
        facilityList.add(facility);
        facilityList.add(facility1);
        MyFacilityDto.response response = new MyFacilityDto.response(username,facilityList);
        given(myFacilityService.getMyFacilitys(Mockito.anyString())).willReturn(response);

        ResultActions actions = mockMvc.perform(
                get("/myfacility/{username}", username)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isOk())
                .andExpect(jsonPath(".username").value(response.getUsername()))
                .andExpect(jsonPath(".facilityList[0].facilityName").value(response.getFacilityList().get(0).getFacilityName()))
                .andExpect(jsonPath(".facilityList[1].facilityName").value(response.getFacilityList().get(1).getFacilityName()))
                .andExpect(jsonPath(".facilityList[0].facilityStatus").value(String.valueOf(response.getFacilityList().get(0).getFacilityStatus())))
                .andExpect(jsonPath(".facilityList[1].facilityStatus").value(String.valueOf(response.getFacilityList().get(1).getFacilityStatus())))
                .andExpect(jsonPath(".facilityList[0].location").value(response.getFacilityList().get(0).getLocation()))
                .andExpect(jsonPath(".facilityList[1].location").value(response.getFacilityList().get(1).getLocation()))
                .andDo(document(
                        "get-myfacility",
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("username").description("회원 닉네임")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("username").type(JsonFieldType.STRING).description("회원 닉네임"),
                                        fieldWithPath("facilityList").type(JsonFieldType.ARRAY).description("내 운동시설 리스트"),
                                        fieldWithPath("facilityList[0]").type(JsonFieldType.ARRAY).description("내 운동시설1"),
                                        fieldWithPath("facilityList[0].facilityId").type(JsonFieldType.NUMBER).description("내 운동시설 ID"),
                                        fieldWithPath("facilityList[0].facilityName").type(JsonFieldType.STRING).description("내 운동시설 이름"),
                                        fieldWithPath("facilityList[0].location").type(JsonFieldType.STRING).description("내 운동시설 좌표"),
                                        fieldWithPath("facilityList[0].facilityStatus").type(JsonFieldType.STRING).description("내 운동시설 상태"),
                                        fieldWithPath("facilityList[1]").type(JsonFieldType.ARRAY).description("내 운동시설2"),
                                        fieldWithPath("facilityList[1].facilityId").type(JsonFieldType.NUMBER).description("내 운동시설 ID"),
                                        fieldWithPath("facilityList[1].facilityName").type(JsonFieldType.STRING).description("내 운동시설 이름"),
                                        fieldWithPath("facilityList[1].location").type(JsonFieldType.STRING).description("내 운동시설 좌표"),
                                        fieldWithPath("facilityList[1].facilityStatus").type(JsonFieldType.STRING).description("내 운동시설 상태")
                                )
                        )
                ));
    }
}
