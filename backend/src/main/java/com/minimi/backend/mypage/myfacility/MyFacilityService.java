package com.minimi.backend.mypage.myfacility;


import com.minimi.backend.auth.domain.Auth;
import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facility.domain.FacilityRepository;
import com.minimi.backend.facility.facility.mapper.FacilityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyFacilityService {

    private final MyFacilityRepository myFacilityRepository;
    private final FacilityRepository facilityRepository;
    private final FacilityMapper facilityMapper;



    public MyFacilityDto.response getMyFacilitys(String username) {
        if (!myFacilityRepository.existsByUsername(username)){
            return null;
        }
        MyFacilityDto.response response = new MyFacilityDto.response();
        response.setUsername(username);
        response.setFacilityList(new ArrayList<>());
        MyFacility myFacility = myFacilityRepository.findByUsername(username);

        myFacility.getFacilityIdList().removeAll(Arrays.asList("",null));
        if (myFacility.getFacilityIdList().isEmpty()){
            return null;
        }
        myFacility.getFacilityIdList().forEach(
                facilityId -> {
                    Facility facility = facilityRepository.findById(Long.valueOf(facilityId))
                            .orElse(new Facility());
                    response.getFacilityList().add(facilityMapper.facilityToFacilityDtoResMyFacility(facility));
                }
        );
        return response;
    }

    public void postMyFacilitys(MyFacilityDto.request myFacilityDtoReq) {
        String username = myFacilityDtoReq.getUsername();
        String facilityId = String.valueOf(myFacilityDtoReq.getFacilityId());
        if (!facilityRepository.existsById(myFacilityDtoReq.getFacilityId())){
            throw new NullPointerException("not found facility");
        }
        if (!myFacilityRepository.existsByUsername(username)){
            List<String> facilityIdList = new ArrayList<>();
            facilityIdList.add(facilityId);
            myFacilityRepository.save(new MyFacility(username,facilityIdList));
            return;
        }

        MyFacility myFacility = myFacilityRepository.findByUsername(username);
        if (myFacility.getFacilityIdList().contains(facilityId)){
            return;
        }
        myFacility.getFacilityIdList().add(facilityId);
        myFacilityRepository.save(myFacility);
    }

    public void deleteyFacilitys(Long facilityId, String username) {
        if (!myFacilityRepository.existsByUsername(username)){
            throw new NullPointerException("my facility not found");
        }
        MyFacility myFacility = myFacilityRepository.findByUsername(username);
        myFacility.getFacilityIdList().remove(String.valueOf(facilityId));
        myFacilityRepository.save(myFacility);
    }
}
