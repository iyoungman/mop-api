package com.youngman.mop.repository;

import com.youngman.mop.model.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-05-13.
 */

public interface ClubRepository extends JpaRepository<Club, Long> {
}
