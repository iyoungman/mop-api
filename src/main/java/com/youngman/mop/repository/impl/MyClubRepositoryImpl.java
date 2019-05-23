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

import static com.youngman.mop.model.QMember.member;
import static com.youngman.mop.model.QMyClub.myClub;
import static com.youngman.mop.model.QClub.club;

/**
 * Created by YoungMan on 2019-05-23.
 */

public class MyClubRepositoryImpl extends QuerydslRepositorySupport implements MyClubRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public MyClubRepositoryImpl() {
		super(MyClub.class);
	}

	@Override
	public List<MyClubResponseDto> fetchMyClubsByUserId(String email) {

		JPAQuery<Member> jpaQuery = new JPAQuery<>(entityManager);

		List<MyClub> myClubs = jpaQuery.distinct()
				.select(myClub)
				.from(member)
				.innerJoin(myClub.member).fetchJoin()
				.innerJoin(myClub.club).fetchJoin()
				.where(member.email.eq(email))
				.fetch()
		;

		return null;
	}

}
