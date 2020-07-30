package com.iyoungman.mop.api.domain.club.domain;

import static com.iyoungman.mop.api.domain.club.domain.QClub.club;

import com.iyoungman.mop.api.common.model.Address;
import com.iyoungman.mop.api.domain.club.api.response.ClubResponse;
import com.iyoungman.mop.api.domain.member.domain.Member;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * Created by YoungMan on 2019-05-25.
 */

@Component
public class ClubRepositoryImpl extends QuerydslRepositorySupport implements ClubRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public ClubRepositoryImpl() {
        super(Club.class);
    }

    @Override
    public Page<ClubResponse> selectPagingClubsByMemberAddress(Address address, Pageable pageable) {
        JPAQuery<ClubResponse> jpaQuery = new JPAQuery<>(entityManager);

        jpaQuery = jpaQuery.select(Projections.constructor(ClubResponse.class,
                club.id,
                club.name,
                club.introduce,
                club.createdDate,
                club.address,
                club.introduce,
                club.clubImage.imagePath)
        )
                .from(club)
                .where(eqAddress(address));

        List<ClubResponse> clubResponses = getQuerydsl().applyPagination(pageable, jpaQuery).fetch();
        return new PageImpl<>(clubResponses, pageable, jpaQuery.fetchCount());
    }

    private BooleanExpression eqAddress(Address address) {
        if (ObjectUtils.isEmpty(address)) {
            return null;
        }

        return club.address.eq(address);
    }

    public List<Member> selectClubMembers(Long clubId) {
//        JPAQuery<Member> jpaQuery = new JPAQuery<>(entityManager);
//        return jpaQuery.select(member)
//                .from(club)
//                .innerJoin(club.myClubs, myClub)
//                .innerJoin(myClub.member, member)
//                .where(eqClubId(clubId))
//                .orderBy(member.email.asc())
//                .fetch();

        return null;
    }


    private BooleanExpression eqClubId(Long clubId) {
        if (ObjectUtils.isEmpty(clubId)) {
            return null;
        }
        return club.id.eq(clubId);
    }

}
