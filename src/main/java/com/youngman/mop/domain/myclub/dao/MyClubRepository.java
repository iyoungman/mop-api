package com.youngman.mop.domain.myclub.dao;

import com.youngman.mop.domain.myclub.domain.MyClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by YoungMan on 2019-05-12.
 */

public interface MyClubRepository extends JpaRepository<MyClub, Long>, MyClubRepositoryCustom {

	@Transactional
	@Modifying
	@Query("DELETE FROM  MyClub m WHERE m.member.id = :memberId AND m.club.id = :clubId")
	void deleteByMemberAndAndClub(@Param("memberId") Long memberId, @Param("clubId") Long clubId);
}
