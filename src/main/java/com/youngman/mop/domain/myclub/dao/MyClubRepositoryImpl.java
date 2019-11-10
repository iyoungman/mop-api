package com.youngman.mop.domain.myclub.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.youngman.mop.domain.myclub.domain.MyClub;
import com.youngman.mop.domain.myclub.dto.MyClubResponse;
import lombok.Getter;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

import static com.youngman.mop.domain.club.domain.QClub.club;
import static com.youngman.mop.domain.member.domain.QMember.member;
import static com.youngman.mop.domain.myclub.domain.QMyClub.myClub;
import static com.youngman.mop.domain.schedule.domain.QSchedule.schedule;

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

        return jpaQuery.select(Projections.constructor(MyClubResponse.class,
                club.id, club.name, club.introduce, club.createdDate, club.region, club.hobby, club.imagePath,
                new CaseBuilder()
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


    public boolean isExistMyClubByMemberEmailAndClubId(String email, Long clubId) {
        JPAQuery<MyClub> jpaQuery = new JPAQuery<>(entityManager);

        List<MyClub> myClubs = jpaQuery.from(myClub)
                .innerJoin(myClub.member, member)
                .innerJoin(myClub.club, club)
                .where(eqMemberEmail(email))
                .where(eqClubId(clubId))
                .fetch();

        return myClubs.size() != 0;
    }

    private BooleanExpression eqClubId(Long clubId) {
        if (clubId == null) {
            return null;
        }
        return club.id.eq(clubId);
    }
}
