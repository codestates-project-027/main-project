package com.minimi.backend.facility.facamapping.service;


import com.minimi.backend.facility.facamapping.domain.FacaMapping;
import com.minimi.backend.facility.facamapping.domain.FacaMappingRepository;
import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("facaMapping patch test")
public class FacaMappingServicePatchTests {

    @Mock
    private FacaMappingRepository facaMappingRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private FacaMappingServiceImpl facaMappingService;


    private FacaMapping facaMapping;
    private Facility facility;
    private FacilityCategory facilityCategory;

    @BeforeEach
    void setup(){
        facility = new Facility();
        facilityCategory = new FacilityCategory();
        facaMapping = new FacaMapping(
                1L,
                1L,
                1L,
                facilityCategory,
                facility
        );
    }


    @Nested
    @DisplayName("Success Case")
    class success {

        @Test
        @DisplayName("success test 1 -> patch category")
        public void successTest1() throws Exception {
            FacilityCategory facilityCategory2 = new FacilityCategory(
                    2L,
                    "222",
                    "헬스"
            );
            FacaMapping facaMapping2 = new FacaMapping(
                    1L,
                    2L,
                    1L,
                    facilityCategory2,
                    facility
            );
            given(facaMappingRepository.existsByFaId(Mockito.anyLong())).willReturn(true);
            given(facaMappingRepository.findByFaIdAndFacaId(Mockito.anyLong(),Mockito.anyLong())).willReturn(facaMapping);
            given(facaMappingRepository.save(facaMapping)).willReturn(facaMapping2);


            FacaMapping result = facaMappingService.patchFacaMapping(1L,facilityCategory2);


            then(facaMappingRepository).should(times(1))
                    .existsByFaId(Mockito.anyLong());
            then(facaMappingRepository).should(times(1))
                    .findByFaIdAndFacaId(Mockito.anyLong(), Mockito.anyLong());
            then(facaMappingRepository).should(times(1))
                    .save(Mockito.any(FacaMapping.class));
            assertThat(result, equalTo(facaMapping2));
        }
    }

    @Nested
    @DisplayName("fail Case")
    class fail {

        @Test
        @DisplayName("fail test 1 -> not exists facaMapping")
        public void failTest1() throws Exception {
            given(facaMappingRepository.existsByFaId(Mockito.anyLong())).willReturn(false);


            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                        FacaMapping result = facaMappingService.patchFacaMapping(2L, facilityCategory);
                    });

            then(facaMappingRepository).should(times(1))
                    .existsByFaId(Mockito.anyLong());
            then(facaMappingRepository).should(times(0))
                    .findByFaIdAndFacaId(Mockito.anyLong(), Mockito.anyLong());
            then(facaMappingRepository).should(times(0))
                    .save(Mockito.any(FacaMapping.class));
            assertThat(exception.getMessage(), equalTo("Not Found FacaMapping"));
        }

        @Test
        @DisplayName("fail test 2 -> null facilityId")
        public void failTest2() throws Exception {

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                FacaMapping result = facaMappingService.patchFacaMapping(null, facilityCategory);
            });

            then(facaMappingRepository).should(times(0))
                    .existsByFaId(Mockito.anyLong());
            then(facaMappingRepository).should(times(0))
                    .findByFaIdAndFacaId(Mockito.anyLong(), Mockito.anyLong());
            then(facaMappingRepository).should(times(0))
                    .save(Mockito.any(FacaMapping.class));
            assertThat(exception.getMessage(), equalTo("Null Value"));
        }

        @Test
        @DisplayName("fail test 3 -> null facilityCategory")
        public void failTest3() throws Exception {

            Exception exception = Assertions.assertThrows(Exception.class, () -> {
                FacaMapping result = facaMappingService.patchFacaMapping(1L, null);
            });

            then(facaMappingRepository).should(times(0))
                    .existsByFaId(Mockito.anyLong());
            then(facaMappingRepository).should(times(0))
                    .findByFaIdAndFacaId(Mockito.anyLong(), Mockito.anyLong());
            then(facaMappingRepository).should(times(0))
                    .save(Mockito.any(FacaMapping.class));
            assertThat(exception.getMessage(), equalTo("Null Value"));
        }
    }
}
