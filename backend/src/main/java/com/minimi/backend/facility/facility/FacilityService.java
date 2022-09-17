package com.minimi.backend.facility.facility;


import com.minimi.backend.facility.facility.FacilityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacilityService {
    public FacilityDto.response getFacility(Long facilityId) {
        return null;
    }

    public Slice<FacilityDto.responsePage> getNearFacilityList(String location, int page) {
        return null;
    }
}
