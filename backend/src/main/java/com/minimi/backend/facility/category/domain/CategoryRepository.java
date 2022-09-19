package com.minimi.backend.facility.category.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryCode(String categoryCode);
    Optional<Category> findByCategoryTitle(String categoryTitle);

    Boolean existsByCategoryCode(String categoryCode);
    Boolean existsByCategoryTitle(String categoryTitle);
}
