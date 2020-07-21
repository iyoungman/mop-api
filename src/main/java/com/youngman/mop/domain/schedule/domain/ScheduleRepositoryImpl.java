package com.youngman.mop.domain.schedule.domain;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import java.time.LocalDateTime;
import java.util.Optional;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

import static com.youngman.mop.domain.club.domain.QClub.club;
import static com.youngman.mop.domain.schedule.domain.QSchedule.schedule;

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

//        return jpaQuery.from(schedule)
//                .innerJoin(schedule.club, club)
//                .where(eqClubId(clubId), eqYear(date), eqMonth(date))
//                .orderBy(schedule.meetingTime.asc())
//                .fetch();
        return null;
    }

    private BooleanExpression eqYear(LocalDate date) {
//        if (ObjectUtils.isEmpty(date)) {
//            return null;
//        }
//        return schedule.meetingTime.year().eq(date.getYear());
        return null;
    }

    private BooleanExpression eqMonth(LocalDate date) {
//        if (ObjectUtils.isEmpty(date)) {
//            return null;
//        }
//        return schedule.meetingTime.month().eq(date.getMonthValue());
        return null;
    }

    @Override
    public Optional<LocalDateTime> findMeetingTimeByUpcoming(Long clubId) {
        JPAQuery<Schedule> jpaQuery = new JPAQuery<>(entityManager);

        LocalDateTime result = jpaQuery.select(schedule.meetingTime.min())
                .from(schedule)
                .where(eqClubId(clubId), isAfterSchedule())
                .fetchOne();

        return Optional.ofNullable(result);
    }

    private BooleanExpression eqClubId(Long clubId) {
        if (ObjectUtils.isEmpty(clubId)) {
            return null;
        }
        return schedule.clubId.eq(clubId);
    }

    private BooleanExpression isAfterSchedule() {
        return schedule.meetingTime.after(LocalDateTime.now());
    }

}