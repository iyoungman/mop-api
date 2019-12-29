package com.youngman.mop.original.myclub.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by YoungMan on 2019-05-12.
 */

public interface MyClubRepository extends JpaRepository<MyClub, Long>, MyClubRepositoryCustom {

	@Query()
	void deleteByMemberAndAndClub(@Param("email") String email, @Param("clubId") Long clubId);
}
