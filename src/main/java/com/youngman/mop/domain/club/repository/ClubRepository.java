package com.youngman.mop.domain.club.repository;

import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.repository.ClubRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-05-13.
 */

public interface ClubRepository extends JpaRepository<Club, Long>, ClubRepositoryCustom {
}
