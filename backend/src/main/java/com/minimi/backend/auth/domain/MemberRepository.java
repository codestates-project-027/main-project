package com.minimi.backend.auth.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByUsername(String auth);
    Member findByEmail(String email);
}
