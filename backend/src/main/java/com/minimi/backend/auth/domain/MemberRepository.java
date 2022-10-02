package com.minimi.backend.auth.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Auth,Long> {
    Auth findByUsername(String auth);

}
