package com.minimi.backend.facility.review.domain;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReviewFacilityRepository extends JpaRepository<ReviewFacility, Long> {

    void deleteByFacilityId(Long facilityId);

    Boolean existsByFacilityId(Long facilityId);

    ReviewFacility findByFacilityId(Long facilityId);

}
