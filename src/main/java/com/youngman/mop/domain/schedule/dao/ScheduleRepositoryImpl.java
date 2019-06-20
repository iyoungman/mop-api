package com.youngman.mop.domain.schedule.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.youngman.mop.domain.myclub.dto.MyClubResponse;
import com.youngman.mop.domain.schedule.domain.Schedule;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.youngman.mop.domain.schedule.domain.QSchedule.schedule;
import static com.youngman.mop.domain.club.domain.QClub.club;

/**
 * Created by YoungMan on 2019-05-25.
 */

@Component
public class ScheduleRepositoryImpl extends QuerydslRepositorySupport implements ScheduleRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public ScheduleRepositoryImpl() {
		super(Schedule.class);
	}


	public List<Schedule> fetchSchedulsByClubIdAndMonthly(Long clubId) {
		JPAQuery<Schedule> jpaQuery = new JPAQuery<>(entityManager);

		return jpaQuery.from(schedule)
				.innerJoin(schedule.club, club)
				.where(eqClubId(clubId))
				.groupBy(schedule.meetingTime.year(), schedule.meetingTime.month())
				.fetch();
	}

	private BooleanExpression eqClubId(Long clubId) {
		if (ObjectUtils.isEmpty(clubId)) {
			return null;
		}
		return club.id.eq(clubId);
	}

}