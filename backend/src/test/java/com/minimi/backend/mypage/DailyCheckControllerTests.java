package com.minimi.backend.mypage;

import com.google.gson.Gson;
import com.minimi.backend.mypage.dailycheck.DailyCheckController;
import com.minimi.backend.mypage.dailycheck.DailyCheckDto;
import com.minimi.backend.mypage.dailycheck.DailyCheckService;
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
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DailyCheckController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class DailyCheckControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private DailyCheckService dailyCheckService;

    @Test
    public void postDailyCheck() throws Exception{
        String username = "MiniMiUser";
        String location = "36.12345, 121.324235";
        Long myFacilityId = 1L;
        DailyCheckDto.request request = new DailyCheckDto.request(username,location,myFacilityId);
        String content = gson.toJson(request);
        DailyCheckDto.response response = new DailyCheckDto.response(username, myFacilityId, true);
        given(dailyCheckService.postCheck(Mockito.any(DailyCheckDto.request.class))).willReturn(response);

        ResultActions actions = mockMvc.perform(
                post("/dailycheck")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath(".username").value(username))
                .andExpect(jsonPath(".facilityId").value(myFacilityId.intValue()))
                .andExpect(jsonPath(".check").value(true))
                .andDo(document(
                "post-dailyCheck",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                List.of(
                                fieldWithPath("username").description("회원 닉네임"),
                                fieldWithPath("location").description("위치 정보"),
                                fieldWithPath("facilityId").description("시설 Id"))),
                        responseFields(
                                List.of(
                                        fieldWithPath("username").type(JsonFieldType.STRING).description("회원 닉네임"),
                                        fieldWithPath("facilityId").type(JsonFieldType.NUMBER).description("시설 Id"),
                                        fieldWithPath("check").type(JsonFieldType.BOOLEAN).description("출석 여부")))
        ));
    }

    @Test
    public void getDailyChecks() throws Exception {
        String username = "MiniMiUser";
        List<String> dailyCheckList = new ArrayList<>();
        dailyCheckList.add("true");
        dailyCheckList.add("true");
        dailyCheckList.add("false");
        dailyCheckList.add("true");

        DailyCheckDto.ResponseCalendar responseCalendar = new DailyCheckDto.ResponseCalendar(username,dailyCheckList);
        given(dailyCheckService.getDailyChecks(Mockito.anyString())).willReturn(responseCalendar);

        ResultActions actions = mockMvc.perform(
                get("/dailycheck/{username}", username)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isOk())
                .andExpect(jsonPath(".username").value(username))
                .andExpect(jsonPath(".checkDailyList[0]").value(dailyCheckList.get(0)))
                .andExpect(jsonPath(".checkDailyList[1]").value(dailyCheckList.get(1)))
                .andExpect(jsonPath(".checkDailyList[2]").value(dailyCheckList.get(2)))
                .andExpect(jsonPath(".checkDailyList[3]").value(dailyCheckList.get(3)))
                .andDo(document(
                        "get-dailyChecks",
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("username").description("회원 닉네임")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("username").type(JsonFieldType.STRING).description("회원 닉네임"),
                                        fieldWithPath("checkDailyList").type(JsonFieldType.ARRAY).description("내 출석 리스트")
                                )
                        )
                ));
    }

}
