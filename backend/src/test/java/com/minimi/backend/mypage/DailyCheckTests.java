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

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
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
                get("/dailyCheck")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath(".username").value(username))
                .andExpect(jsonPath(".facilityName").value(facilityName))
                .andExpect(jsonPath(".check").value(true));
    }
}
