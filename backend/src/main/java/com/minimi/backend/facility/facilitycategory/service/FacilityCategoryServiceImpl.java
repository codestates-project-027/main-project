package com.minimi.backend.facility.facilitycategory.service;

import com.minimi.backend.facility.facility.domain.Facility;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FacilityCategoryServiceImpl implements FacilityCategoryService {

    private final FacilityCategoryRepository facilityCategoryRepository;
    @Override
    public FacilityCategory postFacilityCategory(String categoryCode, String categoryTitle) {
        if (categoryCode==null || categoryTitle==null) throw new NullPointerException("Null Value");
        checkDataAndBlank(facilityCategoryRepository.existsByCategoryCode(categoryCode),
                categoryCode, "Exists CategoryCode");
        checkDataAndBlank(facilityCategoryRepository.existsByCategoryTitle(categoryTitle),
                categoryTitle, "Exists CategoryTitle");

        return facilityCategoryRepository.save(
                FacilityCategory.builder()
                .categoryCode(categoryCode).
                categoryTitle(categoryTitle).build());
    }

    @Override
    public FacilityCategory patchFacilityCategory(String categoryCode, String categoryTitle) {
        return null;
    }

    @Override
    public Boolean checkExistsByCategoryCode(String categoryCode) {
        return facilityCategoryRepository.existsByCategoryCode(categoryCode);
    }

    public Boolean checkDataAndBlank(boolean repositoryExists,String value, String Exists_Message) {
        if (value.isBlank()) {
            throw new NullPointerException("Null Value");
        }
        if (repositoryExists){
            throw new RuntimeException(Exists_Message);
        }
        return true;
    }
}
