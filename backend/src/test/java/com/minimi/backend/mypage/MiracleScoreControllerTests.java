package com.minimi.backend.mypage;

import com.google.gson.Gson;
import com.minimi.backend.mypage.miraclescore.MiracleScoreDto;
import com.minimi.backend.mypage.miraclescore.MiracleScoreController;
import com.minimi.backend.mypage.miraclescore.MiracleScoreService;
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

import java.util.List;

import static com.minimi.backend.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(MiracleScoreController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class MiracleScoreControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private MiracleScoreService miracleScoreService;

    @Test
    public void getScore() throws Exception{

        String username = "MiniMiUser";
        MiracleScoreDto.response response = new MiracleScoreDto.response(username,575);
        given(miracleScoreService.getScore(Mockito.anyString())).willReturn(response);

        ResultActions actions = mockMvc.perform(
                get("/miracleScore/{username}", username)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isOk())
                .andExpect(jsonPath(".username").value(response.getUsername()))
                .andExpect(jsonPath(".score").value(response.getScore()))
                .andDo(document(
                        "get-miracleScore",
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("username").description("회원 닉네임")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("username").type(JsonFieldType.STRING).description("회원 닉네임"),
                                        fieldWithPath("score").type(JsonFieldType.NUMBER).description("미라클 스코어")
                                )
                        )
                ));
    }
}
