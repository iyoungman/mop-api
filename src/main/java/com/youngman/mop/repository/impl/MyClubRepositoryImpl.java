package com.youngman.mop.repository.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.youngman.mop.model.domain.MyClub;
import com.youngman.mop.model.dto.MyClubResponseDto;
import com.youngman.mop.repository.custom.MyClubRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

import static com.youngman.mop.model.domain.QMember.member;
import static com.youngman.mop.model.domain.QMyClub.myClub;
import static com.youngman.mop.model.domain.QClub.club;
import static com.youngman.mop.model.domain.QSchedule.schedule;

/**
 * Created by YoungMan on 2019-05-23.
 */

public class MyClubRepositoryImpl extends QuerydslRepositorySupport implements MyClubRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public MyClubRepositoryImpl() {
		super(MyClub.class);
	}

//	@Override
	/*public List<MyClub> fetchMyClubsByMemberEmail(String email) {

		JPAQuery<MyClub> jpaQuery = new JPAQuery<>(entityManager);

		List<MyClub> myClubs = jpaQuery.distinct()
				.select(myClub)
				.from(myClub)
				.innerJoin(myClub.member, member)
				.innerJoin(myClub.club, club).fetchJoin()
				.innerJoin(club.schedule, schedule).fetchJoin()
				.where(eqMemberEmail(email))
				.fetch()
		;

		return myClubs;
	}*/

	@Override
	public List<MyClubResponseDto> fetchMyClubsByMemberEmail(String email) {

		JPAQuery<MyClubResponseDto> jpaQuery = new JPAQuery<>(entityManager);

		return jpaQuery.select(Projections.constructor(MyClubResponseDto.class,
				club.id, club.name, club.introduce, club.createDate, club.region, club.hobby, schedule.name, schedule.meetingTime))
				.from(myClub)
				.innerJoin(myClub.member, member)
				.innerJoin(myClub.club, club)
				.innerJoin(club.schedule, schedule)
				.where(eqMemberEmail(email), isAfterSchedule())
				.groupBy(club.id)
//				.orderBy(schedule.meetingTime.asc().)
				.fetch();
	}

	private BooleanExpression eqMemberEmail(String email) {
		if (StringUtils.isEmpty(email)) {
			return null;
		}
		return member.email.eq(email);
	}

	private BooleanExpression isAfterSchedule() {
		return schedule.meetingTime.after(LocalDateTime.now());
	}

	private BooleanExpression isLimit() {
		return schedule.count().eq(1L);
	}


	public List<MyClubResponseDto> fetchClubsByMemberInfo(String email, String address, int pageNo) {

		final int pageSize = 24;

		JPAQuery<MyClub> jpaQuery = new JPAQuery<>(entityManager);

		List<MyClub> myClubs = jpaQuery.distinct()
				.select(myClub)
				.from(member)
				.innerJoin(myClub.member).fetchJoin()
				.innerJoin(myClub.club).fetchJoin()
				.where(eqMemberEmail(email), eqMemberAddress(address))
				.offset(calculateOffset(pageSize, pageNo)).limit(pageSize)
				.fetch();
		return null;
	}

	private BooleanExpression eqMemberAddress(String address) {
		if (StringUtils.isEmpty(address)) {
			return null;
		}
		return club.region.eq(address);
	}

	private long calculateOffset(int pageSize, int pageNo) {
		return (long) (pageSize * (pageNo - 1));
	}
}
