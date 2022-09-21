package com.minimi.backend.facility.facilitycategory.domain;

import com.minimi.backend.facility.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityCategoryRepository extends JpaRepository<FacilityCategory, Long> {

    Boolean existsByCategoryCode(String categoryCode);

    Boolean existsByCategoryTitle(String categoryTitle);

    FacilityCategory findByCategoryCode(String categoryCode);

    FacilityCategory findByCategoryTitle(String categoryTitle);

}
