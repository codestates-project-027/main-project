package com.minimi.backend.mypage.myfacility;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyFacilityRepository extends JpaRepository<MyFacility, Long> {

    MyFacility findByUsername(String username);
    Boolean existsByUsername(String username);

}
