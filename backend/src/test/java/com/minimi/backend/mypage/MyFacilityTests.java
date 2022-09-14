package com.minimi.backend.mypage;


import com.google.gson.Gson;
import com.minimi.backend.mypage.domain.MiracleScoreDto;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MyFacilityController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class MyFacilityTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private MyFacilityService myFacilityService;

    @Test
    public void getMyFacilitys() throws Exception {
        String username = "미니미회원";
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
                .andExpect(jsonPath(".facilityList[1]").value(response.getFacilityList().get(1)));
    }
}
