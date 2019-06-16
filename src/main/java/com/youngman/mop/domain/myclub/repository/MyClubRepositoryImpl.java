package com.youngman.mop.domain.myclub.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.youngman.mop.domain.myclub.domain.MyClub;
import com.youngman.mop.domain.myclub.dto.MyClubResponse;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

import static com.youngman.mop.domain.entity.QClub.club;
import static com.youngman.mop.domain.entity.QMember.member;
import static com.youngman.mop.domain.entity.QMyClub.myClub;
import static com.youngman.mop.domain.entity.QSchedule.schedule;

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
	public List<MyClubResponse> fetchMyClubsByMemberEmail(String email) {

		JPAQuery<MyClubResponse> jpaQuery = new JPAQuery<>(entityManager);

		return  jpaQuery.select(Projections.constructor(MyClubResponse.class,
				club.id, club.name, club.introduce, club.createDate, club.region, club.hobby, new CaseBuilder()
						.when(isAfterSchedule())
						.then(schedule.meetingTime.min())
						.otherwise((LocalDateTime) null).as("meetingTime"))
				)
				.from(myClub)
				.innerJoin(myClub.member, member)
				.innerJoin(myClub.club, club)
				.leftJoin(club.schedule, schedule)
				.where(eqMemberEmail(email))
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
