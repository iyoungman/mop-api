package com.youngman.mop.domain.myclub.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by YoungMan on 2019-05-12.
 */

public interface MyClubRepository extends JpaRepository<MyClub, Long>, MyClubRepositoryCustom {

    @Query("SELECT m.clubId FROM MyClub m WHERE m.memberId = :memberId")
    List<Long> findClubIdsByMemberId(Long memberId);

    void deleteByMemberIdAndClubId(Long memberId, Long clubId);
}
