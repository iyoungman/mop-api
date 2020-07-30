package com.iyoungman.mop.api.domain.myclub.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by YoungMan on 2019-05-12.
 */

public interface MyClubRepository extends JpaRepository<MyClub, Long>, MyClubRepositoryCustom {

    @Query("SELECT m.clubId FROM MyClub m WHERE m.memberId = :memberId")
    List<Long> findClubIdsByMemberId(Long memberId);

    @Query("SELECT m.memberId FROM MyClub m WHERE m.clubId = :clubId")
    List<Long> findMemberIdsByClubId(Long clubId);

    void deleteByMemberIdAndClubId(Long memberId, Long clubId);
}
