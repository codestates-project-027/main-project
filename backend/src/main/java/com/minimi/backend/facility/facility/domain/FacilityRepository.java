package com.minimi.backend.facility.facility.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility, Long>{

    Slice<Facility> findByFacilityStatus(FacilityStatus facilityStatus, Pageable pageable);

}
