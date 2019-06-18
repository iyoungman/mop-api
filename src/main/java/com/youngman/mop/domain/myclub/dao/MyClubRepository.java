package com.youngman.mop.domain.myclub.dao;

import com.youngman.mop.domain.myclub.domain.MyClub;
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
