package com.minimi.backend.facility.facilitycategory.service;

import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
@DisplayName("checkFacilityCategory test")
public class FacilityCategoryServiceCheckTests {
    @Mock
    private FacilityCategoryRepository facilityCategoryRepository;

    @InjectMocks
    private FacilityCategoryServiceImpl facilityCategoryService;

    private String title;
    private String code;

    @BeforeEach
    public void setup() {
        title = "헬스";
        code = "220909";
    }

    @Nested
    @DisplayName("check checkDataAndBlank")
    class checkDataAndBlank {
        @Nested
        @DisplayName("success checkDataAndBlank case")
        class successCase{
            @Test
            @DisplayName("success checkDataAndBlank test 1 -> success check")
            public void successTest1() throws Exception {

                Boolean result = facilityCategoryService.checkDataAndBlank(false, "value", "Exists_Message");

                assertThat(result, equalTo(true));
            }
        }

        @Nested
        @DisplayName("fail checkDataAndBlank case")
        class failCase {
            @Test
            @DisplayName("fail checkDataAndBlank test 1 -> repository Exists")
            public void failTest1() throws Exception {

                Exception exception = Assertions.assertThrows(Exception.class, () -> {
                    Boolean result = facilityCategoryService.checkDataAndBlank(true, "value", "Exists Message");
                });

                assertThat(exception.getMessage(), equalTo("Exists Message"));
            }
            @Test
            @DisplayName("fail checkDataAndBlank test 1 -> blank value")
            public void failTest2() throws Exception {

                Exception exception = Assertions.assertThrows(Exception.class, () -> {
                    Boolean result = facilityCategoryService.checkDataAndBlank(false, "", "Exists_Message");
                });

                assertThat(exception.getMessage(), equalTo("Null Value"));
            }
        }
    }
    @Nested
    @DisplayName("checkExistsByCategoryCode")
    class checkExistsByCategoryCode {
        @Nested
        @DisplayName("success case")
        class successCase {
            @Test
            @DisplayName("success test 1 -> Exists")
            public void successTest1() throws Exception {
                given(facilityCategoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(true);

                Boolean result = facilityCategoryService.checkExistsByCategoryCode("202222");

                assertThat(result, equalTo(true));
            }
        }

        @Nested
        @DisplayName("fail case")
        class failCase {
            @Test
            @DisplayName("fail test 1 -> not Exists")
            public void failTest1() throws Exception {
                given(facilityCategoryRepository.existsByCategoryCode(Mockito.anyString())).willReturn(false);

                Boolean result = facilityCategoryService.checkExistsByCategoryCode("202222");

                assertThat(result, equalTo(false));
            }
        }
    }
}