package com.minimi.backend.facility.facilitycategorylist.service;



import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facility.domain.FacilityStatus;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.service.FacilityCategoryServiceImpl;
import com.minimi.backend.facility.facilitycategorylist.domain.FacilityCategoryList;
import com.minimi.backend.facility.facilitycategorylist.domain.FacilityCategoryListRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("FacilityCategoryListServicePost test")
public class FacilityCategoryListServicePostTests {

    @Mock
    private FacilityCategoryListRepository facilityCategoryListRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private FacilityCategoryListServiceImpl facilityCategoryListService;

    private Facility facility;

    @BeforeEach
    public void setup(){
        facility = new Facility(
                1L,"미니미헬스장","대표이미지",
                new ArrayList<>(Arrays.asList("이미지1", "이미지2")),
                "시설정보","서울특별시 강남구","www.website.com",
                "010-0000-0000","34.12345, 119.12345", 4,
                new ArrayList<>(Arrays.asList("헬스", "PT")), FacilityStatus.PENDING
        );
    }


    @Nested
    @DisplayName("success case")
    class successCase {

        @Test
        @DisplayName("success test 1 -> create")
        public void successTest() throws Exception {
            FacilityCategory facilityCategory = new FacilityCategory(1L,"222222","헬스");
            FacilityCategoryList facilityCategoryList =
                    new FacilityCategoryList(1L, facilityCategory, facility);

            given(facilityCategoryListRepository.save(Mockito.any(FacilityCategoryList.class))).willReturn(facilityCategoryList);


            FacilityCategoryList result = facilityCategoryListService.postFacilityCategoryListEntity(facilityCategory, facility);


            then(facilityCategoryListRepository).should(times(1)).save(Mockito.any(FacilityCategoryList.class));
            assertThat(result, equalTo(facilityCategoryList));
        }

    }
    @Nested
    @DisplayName("fail case")
    class failCase {

        @Test
        @DisplayName("fail test 1 -> null")
        public void failTest() throws Exception {

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                facilityCategoryListService.postFacilityCategoryListEntity(null, null);
            });

            assertThat(exception.getMessage(), equalTo("Null Value"));
        }

        @Test
        @DisplayName("fail test 2 -> blankValue")
        public void failTest2() throws Exception {
            FacilityCategory facilityCategory = new FacilityCategory();
            Facility facility = new Facility();

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                facilityCategoryListService.postFacilityCategoryListEntity(facilityCategory, facility);
            });

            assertThat(exception.getMessage(), equalTo("Null Value"));
        }
    }
}
