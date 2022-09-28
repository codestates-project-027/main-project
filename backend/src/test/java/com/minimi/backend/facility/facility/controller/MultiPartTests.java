package com.minimi.backend.facility.facility.controller;


import com.google.gson.Gson;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import com.minimi.backend.facility.facility.service.FacilityServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FacilityController.class)
@MockBean(JpaMetamodelMappingContext.class)
public class MultiPartTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private FacilityServiceImpl facilityServiceImpl;

    @Test
    public void saveMultipartAndDto() throws Exception {
        MockMultipartFile multipartFile1 = new MockMultipartFile(
                "minimitest","minimitest.png","image/png",new FileInputStream("src/testimg/minimitest.png"));
        MockMultipartFile multipartFile2 = new MockMultipartFile(
                "minimitest","minimitest.png","application/octet-stream",new byte[0]);

        FacilityDto.request requestDto = new FacilityDto.request(
                "시설명","시설정보","주소","www.wwww.www","010-0000-0000","35.123, 199.123",
                new ArrayList<>());
        String requestDtoJson =  gson.toJson(requestDto);
        MockMultipartFile request = new MockMultipartFile("request","request","application/json",requestDtoJson.getBytes(StandardCharsets.UTF_8));

        mockMvc.perform(multipart("/facility")
                        .file(multipartFile1)
                .file(multipartFile2)
                .file(request))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }
}
