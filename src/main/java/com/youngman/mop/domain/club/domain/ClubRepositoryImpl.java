package com.youngman.mop.domain.club.domain;

import static com.youngman.mop.domain.club.domain.QClub.club;
import static com.youngman.mop.domain.member.domain.QMember.member;
import static com.youngman.mop.domain.myclub.domain.QMyClub.myClub;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.youngman.mop.domain.club.api.dto.ClubResponse;
import com.youngman.mop.domain.member.domain.Member;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

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
    public Page<ClubResponse> selectPagingClubsByMember(String email, String address, Pageable pageable) {
//        JPAQuery<ClubResponse> jpaQuery = new JPAQuery<>(entityManager);
//
//        jpaQuery = jpaQuery.select(Projections.constructor(ClubResponse.class,
//                club.id, club.name, club.introduce, club.createdDate, club.address.toString(), club.clubImage.toString(), club.clubImage.toString()))
//                .from(club);
//
//        List<ClubResponse> clubResponses = getQuerydsl()
//                .applyPagination(pageable, jpaQuery)
//                .fetch();
//
//        return new PageImpl<>(clubResponses, pageable, jpaQuery.fetchCount());
        return null;
    }

    private BooleanExpression eqMemberEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return null;
        }
        return member.email.eq(email);
    }

    private BooleanExpression eqMemberAddress(String address) {
//        if (StringUtils.isEmpty(address)) {
//            return null;
//        }
//        return club.region.eq(address);
        return null;
    }

    public Optional<Club> selectClubInfoById(Long clubId) {
//        JPAQuery<Club> jpaQuery = new JPAQuery<>(entityManager);
//
//        Club fetchClub = jpaQuery.select(club)
//                .from(club)
//                .leftJoin(club.myClubs, myClub).fetchJoin()
//                .innerJoin(myClub.member, member).fetchJoin()
//                .where(eqClubId(clubId))
//                .fetchOne();
//
//        return Optional.ofNullable(fetchClub);

        return null;
    }

    private BooleanExpression eqClubId(Long clubId) {
        if (ObjectUtils.isEmpty(clubId)) {
            return null;
        }
        return club.id.eq(clubId);
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
}
