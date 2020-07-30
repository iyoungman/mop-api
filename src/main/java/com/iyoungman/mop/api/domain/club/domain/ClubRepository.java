package com.iyoungman.mop.api.domain.club.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-05-13.
 */

public interface ClubRepository extends JpaRepository<Club, Long>, ClubRepositoryCustom {

    Optional<Club> findByName(String name);

//    @Query("SELECT (COUNT(c) > 0) FROM Club c WHERE c.id = :clubId AND c.chairManId = :memberId")
//    boolean isClubChair(@Param("clubId") Long clubId, @Param("memberId") Long memberId);
}
