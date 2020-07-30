package com.iyoungman.mop.api.domain.myclub.domain;

import static com.iyoungman.mop.api.domain.myclub.domain.QMyClub.myClub;
import static com.iyoungman.mop.api.domain.schedule.domain.QSchedule.schedule;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Component
public class MyClubRepositoryImpl extends QuerydslRepositorySupport implements MyClubRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public MyClubRepositoryImpl() {
        super(MyClub.class);
    }

//    @Override
//    public List<MyClubResponse> fetchMyClubsByMemberId(Long memberId) {
//        JPAQuery<MyClubResponse> jpaQuery = new JPAQuery<>(entityManager);
//
//        return jpaQuery.select(Projections.constructor(MyClubResponse.class,
//                club.id, club.name, club.introduce, club.createdDate, club.name, club.name, club.clubImage.imagePath,
//                new CaseBuilder()
//                        .when(isAfterSchedule())
//                        .then(schedule.meetingTime.min())
//                        .otherwise((LocalDateTime) null).as("meetingTime"))
//        )
//                .from(myClub)
//                .innerJoin(myClub.clubId, club)
//                .leftJoin(club, schedule)
//                .where(eqMemberId(memberId))
//                .orderBy(schedule.meetingTime.asc())
//                .groupBy(club.id)
//                .fetch();
//    }

    private BooleanExpression isAfterSchedule() {
        return schedule.meetingTime.after(LocalDateTime.now());
    }

    @Override
    public boolean isExistMyClubByMemberIdAndClubId(Long memberId, Long clubId) {
        JPAQuery<MyClub> jpaQuery = new JPAQuery<>(entityManager);

        List<MyClub> result = jpaQuery.from(myClub)
                .where(eqClubId(clubId))
                .where(eqMemberId(memberId))
                .fetch();

        return result.size() > 0;
    }

    private BooleanExpression eqClubId(Long clubId) {
        return myClub.clubId.eq(clubId);
    }

    private BooleanExpression eqMemberId(Long memberId) {
        return myClub.memberId.eq(memberId);
    }
}
