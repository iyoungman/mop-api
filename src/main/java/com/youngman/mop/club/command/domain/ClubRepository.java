package com.youngman.mop.club.command.domain;

import com.youngman.mop.club.infra.ClubRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-05-13.
 */

public interface ClubRepository extends JpaRepository<Club, Long>, ClubRepositoryCustom {
}