package com.youngman.mop.repository;

import com.youngman.mop.model.domain.MyClub;
import com.youngman.mop.repository.custom.MyClubRepositoryCustom;
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
