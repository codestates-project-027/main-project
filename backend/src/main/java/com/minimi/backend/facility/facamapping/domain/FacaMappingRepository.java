package com.minimi.backend.facility.facamapping.domain;

import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacaMappingRepository extends JpaRepository<FacaMapping, Long> {
    Slice<FacaMapping> findByFacilityCategory(FacilityCategory facilityCategory, Pageable pageable);

    void deleteAllByFaId(Long facilityId);
}
