package com.youngman.mop.repository.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.youngman.mop.model.Member;
import com.youngman.mop.model.MyClub;
import com.youngman.mop.model.QMember;
import com.youngman.mop.model.QMyClub;
import com.youngman.mop.model.dto.MyClubResponseDto;
import com.youngman.mop.repository.custom.MyClubRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-23.
 */

public class MyClubRepositoryImpl extends QuerydslRepositorySupport implements MyClubRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	private QMyClub myClub = QMyClub.myClub;
	private QMember member = QMember.member;

	public MyClubRepositoryImpl() {
		super(MyClub.class);
	}

	@Override
	public List<MyClubResponseDto> fetchMyClubsByUserId(String email) {
		JPAQuery<Member> jpaQuery = new JPAQuery<>(entityManager);
		List<Member> members = jpaQuery.distinct()
				.select(member)
				.from(member)
				.innerJoin(member.myClubs).fetchJoin()
				.innerJoin(myClub.club).fetchJoin()
				.where(member.email.eq(email))
				.fetch()
		;

		return null;
	}

}
