package com.youngman.mop.repository.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.youngman.mop.model.domain.Club;
import com.youngman.mop.model.domain.MyClub;
import com.youngman.mop.model.dto.MyClubResponseDto;
import com.youngman.mop.repository.custom.ClubRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Objects;

import static com.youngman.mop.model.domain.QClub.club;
import static com.youngman.mop.model.domain.QMember.member;
import static com.youngman.mop.model.domain.QMyClub.myClub;
import static com.youngman.mop.model.domain.QSchedule.schedule;

/**
 * Created by YoungMan on 2019-05-25.
 */

public class ClubRepositoryImpl extends QuerydslRepositorySupport implements ClubRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public ClubRepositoryImpl() {
		super(Club.class);
	}


	@Override
	public Page<MyClubResponseDto> fetchPagingClubsByMember(String email, String address, Pageable pageable) {

		JPAQuery<MyClubResponseDto> jpaQuery = new JPAQuery<>(entityManager);

		jpaQuery =  jpaQuery.select(Projections.constructor(MyClubResponseDto.class,
				club.id, club.name, club.introduce, club.createDate, club.region, club.hobby, schedule.meetingTime.min()))
				.from(myClub)
				.innerJoin(myClub.member, member)
				.innerJoin(myClub.club, club)
				.leftJoin(club.schedule, schedule)
				.where(eqMemberEmail(email), eqMemberAddress(address));

		List<MyClubResponseDto> accounts = Objects.requireNonNull(getQuerydsl()).applyPagination(pageable, jpaQuery).fetch();
		return new PageImpl<>(accounts, pageable, jpaQuery.fetchCount());
	}

	private BooleanExpression eqMemberEmail(String email) {
		if (StringUtils.isEmpty(email)) {
			return null;
		}
		return member.email.eq(email);
	}

	private BooleanExpression eqMemberAddress(String address) {
		if (StringUtils.isEmpty(address)) {
			return null;
		}
		return club.region.eq(address);
	}

	/*public void fetchPagingClubsBySearch(String email, String address, int pageNo) {

	}*/

}
