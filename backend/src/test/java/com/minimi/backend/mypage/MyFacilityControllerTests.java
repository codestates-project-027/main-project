package com.minimi.backend.mypage;


import com.google.gson.Gson;
import com.minimi.backend.mypage.domain.MyFacilityDto;
import com.minimi.backend.mypage.service.MyFacilityService;
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

import static com.minimi.backend.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
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
    public void getMyFacilitys() throws Exception {
        String username = "MiniMiUser";
        List<String> facilityList = new ArrayList<>();
        facilityList.add("집근처GYM");
        facilityList.add("요가와필라테스");
        MyFacilityDto.response response = new MyFacilityDto.response(username,facilityList);
        given(myFacilityService.getMyFacilitys(Mockito.anyString())).willReturn(response);

        ResultActions actions = mockMvc.perform(
                get("/myFacility/{username}", username)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isOk())
                .andExpect(jsonPath(".username").value(response.getUsername()))
                .andExpect(jsonPath(".facilityList[0]").value(response.getFacilityList().get(0)))
                .andExpect(jsonPath(".facilityList[1]").value(response.getFacilityList().get(1)))
                .andDo(document(
                        "get-myFacilityList",
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("username").description("회원 닉네임")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("username").type(JsonFieldType.STRING).description("회원 닉네임"),
                                        fieldWithPath("facilityList[]").type(JsonFieldType.ARRAY).description("내 운동시설 리스트")
                                )
                        )
                ));
    }
}
