package com.minimi.backend.community.contents.domain;

import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContentsRepository extends JpaRepository<Contents, Long> {
    Slice<Contents> findSliceBy(final Contents pageable);
}
