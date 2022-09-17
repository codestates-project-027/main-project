package com.minimi.backend.facility;


import com.google.gson.Gson;
import com.minimi.backend.facility.bookmark.BookmarkController;
import com.minimi.backend.facility.bookmark.BookmarkDto;
import com.minimi.backend.facility.bookmark.BookmarkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.minimi.backend.ApiDocumentUtils.getRequestPreProcessor;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BookmarkController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class BookmarkControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private BookmarkService bookmarkService;

    @Test
    public void postBookmark() throws Exception{
        BookmarkDto.request bookmarkReq = new BookmarkDto.request("미니미회원", 1L);
        String content = gson.toJson(bookmarkReq);
        ResultActions actions = mockMvc.perform(
                post("/bookmark")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        actions.andExpect(status().isCreated())
                .andDo(document(
                        "post-bookmark",
                        getRequestPreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("username").description("유저 닉네임"),
                                        fieldWithPath("facilityId").description("구독 시설 ID")
                                ))
                ));
    }
    @Test
    public void deleteBookmark() throws Exception {
        Long facilityId = 1L;
        ResultActions actions = mockMvc.perform(
                delete("/bookmark/{facilityId}",facilityId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );
        actions.andExpect(status().isNoContent())
                .andDo(document(
                        "delete-bookmark",
                        getRequestPreProcessor(),
                        pathParameters(
                                parameterWithName("facilityId").description("구독취소 시설 ID")
                        )));
    }
}
