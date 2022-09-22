package com.minimi.backend.facility.facamapping.service;


import com.minimi.backend.facility.facamapping.domain.FacaMappingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@DisplayName("delete facaMapping test")
public class FacaMappingServiceDeleteTests {

    @Mock
    private FacaMappingRepository facaMappingRepository;


    @InjectMocks
    private FacaMappingServiceImpl facaMappingService;

    @Test
    @DisplayName("success test")
    public void success() throws Exception {
        Long facilityId = 1L;
        given(facaMappingRepository.existsByFaId(facilityId)).willReturn(true);
        doNothing().when(facaMappingRepository).deleteAllByFaId(facilityId);

        facaMappingService.deleteFacaMapping(facilityId);

        then(facaMappingRepository).should(times(1)).existsByFaId(Mockito.anyLong());
        then(facaMappingRepository).should(times(1)).deleteAllByFaId(Mockito.anyLong());
    }

    @Test
    @DisplayName("fail test")
    public void fail() throws Exception {
        Long facilityId = 1L;
        given(facaMappingRepository.existsByFaId(facilityId)).willReturn(false);

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
                    facaMappingService.deleteFacaMapping(facilityId);
                });

        then(facaMappingRepository).should(times(1)).existsByFaId(Mockito.anyLong());
        then(facaMappingRepository).should(times(0)).deleteAllByFaId(Mockito.anyLong());
        assertThat(exception.getMessage(), equalTo("No Exists"));
    }
}
