package com.minimi.backend.facility.facility.service;


import com.minimi.backend.facility.facility.domain.facility.FacilityRepository;
import com.minimi.backend.facility.facility.service.facility.FacilityServiceImpl;
import com.minimi.backend.facility.facility.service.facility.listener.FacilityCategoryCheckListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("checkFacility test")
public class FacilityServiceCheckTests {
    @Mock
    private FacilityRepository facilityRepository;

    @Mock
    private FacilityCategoryCheckListener facilityCategoryCheckListener;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private FacilityServiceImpl facilityService;

    @Nested
    @DisplayName("checkExistsCategory")
    class checkExists {

        @Nested
        @DisplayName("success ExistsCategory")
        class successCase {

            @Test
            @DisplayName("success ExistsCategory 1 -> exists")
            public void successCaseTest1() throws Exception {
                List<String> categoryList = new ArrayList<>(Arrays.asList("헬스", "요가"));
                given(facilityCategoryCheckListener.checkExistsByCategoryCode(Mockito.anyString()))
                        .willReturn(true);

                Boolean result = facilityService.checkCategory(categoryList);

                then(facilityCategoryCheckListener).should(times(categoryList.size()))
                        .checkExistsByCategoryCode(anyString());
                assertThat(result, equalTo(true));
            }

            @Test
            @DisplayName("fail ExistsCategory 1 -> not exists")
            public void failCaseTest1() throws Exception {
                List<String> categoryList = new ArrayList<>(Arrays.asList("헬스", "요가"));
                given(facilityCategoryCheckListener.checkExistsByCategoryCode(Mockito.anyString()))
                        .willReturn(false);

                Exception exception = Assertions.assertThrows(Exception.class, () -> {
                            facilityService.checkCategory(categoryList);
                        });

                then(facilityCategoryCheckListener).should(times(1)).checkExistsByCategoryCode(anyString());
                assertThat(exception.getMessage(), equalTo("Not Found Category"));
            }
        }
    }
}
