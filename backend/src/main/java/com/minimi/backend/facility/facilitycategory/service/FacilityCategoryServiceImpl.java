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

        FacilityCategory facilityCategory = getFacilityCategoryByCategoryCode(categoryCode);

        checkDataAndBlank(facilityCategoryRepository
                .existsByCategoryTitle(categoryTitle), categoryTitle, "Exists CategoryTitle");

        facilityCategory.setCategoryTitle(categoryTitle);


        return facilityCategoryRepository.save(facilityCategory);
    }

    @Override
    public Boolean checkExistsByCategoryTitle(String categoryTitle) {
        return facilityCategoryRepository.existsByCategoryTitle(categoryTitle);
    }

    @Override
    public FacilityCategory getFacilityCategoryByTitle(String categoryTitle) {
        if (!facilityCategoryRepository.existsByCategoryTitle(categoryTitle)){
            throw new NullPointerException("Null FacilityCategory");
        }
        return facilityCategoryRepository.findByCategoryTitle(categoryTitle);
    }
    @Override
    public FacilityCategory getFacilityCategoryByCategoryCode(String categoryCode) {
        if (!facilityCategoryRepository.existsByCategoryCode(categoryCode)){
            throw new NullPointerException("Null FacilityCategory");
        }
        return facilityCategoryRepository.findByCategoryCode(categoryCode);
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
