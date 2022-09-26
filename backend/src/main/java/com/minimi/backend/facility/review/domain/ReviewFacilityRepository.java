package com.minimi.backend.facility.review.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewFacilityRepository extends JpaRepository<ReviewFacility, Long> {

    void deleteByFacilityId(Long facilityId);

    Boolean existsByFacilityId(Long facilityId);
}
