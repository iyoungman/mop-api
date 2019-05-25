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

import static com.youngman.mop.model.domain.QClub.club;
import static com.youngman.mop.model.domain.QMember.member;
import static com.youngman.mop.model.domain.QMyClub.myClub;
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


	@Override
	public List<MyClubResponseDto> fetchMyClubsByMemberEmail(String email) {

		JPAQuery<MyClubResponseDto> jpaQuery = new JPAQuery<>(entityManager);

		return jpaQuery.select(Projections.constructor(MyClubResponseDto.class,
				club.id, club.name, club.introduce, club.createDate, club.region, club.hobby, schedule.meetingTime.min()))
				.from(myClub)
				.innerJoin(myClub.member, member)
				.innerJoin(myClub.club, club)
				.innerJoin(club.schedule, schedule)
				.where(eqMemberEmail(email), isAfterSchedule())
				.orderBy(schedule.meetingTime.asc())
				.groupBy(club.id)
//				.having(club.id.goe(1))
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


}
