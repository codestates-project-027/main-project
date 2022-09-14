package com.minimi.backend.mypage;

import com.google.gson.Gson;
import com.minimi.backend.mypage.domain.DailyCheckDto;
import com.minimi.backend.mypage.domain.MiracleScoreDto;
import com.minimi.backend.mypage.service.DailyCheckService;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DailyCheckController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class DailyCheckTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private DailyCheckService dailyCheckService;

    @Test
    public void postDailyCheck() throws Exception{
        String username = "미니미회원";
        String location = "36.12345, 121.324235";
        String facilityName = "파워헬스장";
        DailyCheckDto.request request = new DailyCheckDto.request(username,location,facilityName);
        String content = gson.toJson(request);
        DailyCheckDto.response response = new DailyCheckDto.response(username, facilityName, true);
        given(dailyCheckService.postCheck(Mockito.any(DailyCheckDto.request.class))).willReturn(response);

        ResultActions actions = mockMvc.perform(
                post("/dailyCheck")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath(".username").value(username))
                .andExpect(jsonPath(".facilityName").value(facilityName))
                .andExpect(jsonPath(".check").value(true));
    }

    @Test
    public void getDailyChecks() throws Exception {
        String username = "미니미회원";
        List<LocalDate> localDateList = new ArrayList<>();
        localDateList.add(LocalDate.of(2022,8,11));
        localDateList.add(LocalDate.of(2022,8,15));
        localDateList.add(LocalDate.of(2022,9,13));
        DailyCheckDto.ResponseCalendar responseCalendar = new DailyCheckDto.ResponseCalendar(username,localDateList);
        given(dailyCheckService.getDailyChecks(Mockito.anyString())).willReturn(responseCalendar);

        ResultActions actions = mockMvc.perform(
                get("/dailyCheck/{username}", username)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isOk())
                .andExpect(jsonPath(".username").value(username))
                .andExpect(jsonPath(".localDateList[0]").value(String.valueOf(localDateList.get(0))))
                .andExpect(jsonPath(".localDateList[1]").value(String.valueOf(localDateList.get(1))))
                .andExpect(jsonPath(".localDateList[2]").value(String.valueOf(localDateList.get(2))));
    }
}
