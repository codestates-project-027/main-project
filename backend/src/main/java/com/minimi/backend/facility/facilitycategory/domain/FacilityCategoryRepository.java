package com.minimi.backend.facility.facilitycategory.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityCategoryRepository extends JpaRepository<FacilityCategory, Long> {

    Boolean existsByCategoryCode(String categoryCode);
}
