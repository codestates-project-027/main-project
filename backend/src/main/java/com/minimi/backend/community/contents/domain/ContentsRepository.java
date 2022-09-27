package com.minimi.backend.community.contents.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface ContentsRepository extends JpaRepository<Contents, Long> {
    Slice<Contents> findSliceBy(final Pageable pageable);
    @Modifying
    @Query("update Contents c set c.views = c.views + 1 where c.contentsId = :id")
    int updateViews(Long id);
}
