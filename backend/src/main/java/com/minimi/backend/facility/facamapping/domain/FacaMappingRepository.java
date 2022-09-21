package com.minimi.backend.facility.facamapping.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacaMappingRepository extends JpaRepository<FacaMapping, Long> {
    //err
//    Slice<FacaMapping> findByFacilityCategoryId(Long facilityCategoryId, Pageable pageable);
}
