package com.youngman.mop.original.schedule.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.youngman.mop.domain.schedule.domain.Schedule;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

import static com.youngman.mop.original.club.domain.QClub.club;
import static com.youngman.mop.original.schedule.domain.QSchedule.schedule;

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

    @Override
    public List<Schedule> fetchSchedulesByClubIdAndMonthly(Long clubId, LocalDate date) {
        JPAQuery<Schedule> jpaQuery = new JPAQuery<>(entityManager);

        return jpaQuery.from(schedule)
                .innerJoin(schedule.club, club)
                .where(eqClubId(clubId), eqYear(date), eqMonth(date))
                .orderBy(schedule.meetingTime.asc())
                .fetch();
    }

    private BooleanExpression eqClubId(Long clubId) {
        if (ObjectUtils.isEmpty(clubId)) {
            return null;
        }
        return club.id.eq(clubId);
    }

    private BooleanExpression eqYear(LocalDate date) {
        if (ObjectUtils.isEmpty(date)) {
            return null;
        }
        return schedule.meetingTime.year().eq(date.getYear());
    }

    private BooleanExpression eqMonth(LocalDate date) {
        if (ObjectUtils.isEmpty(date)) {
            return null;
        }
        return schedule.meetingTime.month().eq(date.getMonthValue());
    }

}