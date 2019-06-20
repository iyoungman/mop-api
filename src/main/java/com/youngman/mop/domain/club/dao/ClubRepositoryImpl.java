package com.youngman.mop.domain.club.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.myclub.dto.MyClubResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.youngman.mop.domain.club.domain.QClub.club;
import static com.youngman.mop.domain.member.domain.QMember.member;
import static com.youngman.mop.domain.myclub.domain.QMyClub.myClub;
import static com.youngman.mop.domain.schedule.domain.QSchedule.schedule;

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
	public Page<MyClubResponse> fetchPagingClubsByMember(String email, String address, Pageable pageable) {
		JPAQuery<MyClubResponse> jpaQuery = new JPAQuery<>(entityManager);

		jpaQuery = jpaQuery.select(Projections.constructor(MyClubResponse.class,
				club.id, club.name, club.introduce, club.createdDate, club.region, club.hobby, schedule.meetingTime.min()))
				.from(myClub)
				.innerJoin(myClub.member, member)
				.innerJoin(myClub.club, club)
				.leftJoin(club.schedule, schedule)
				.where(eqMemberEmail(email), eqMemberAddress(address));

		List<MyClubResponse> accounts = Objects.requireNonNull(getQuerydsl()).applyPagination(pageable, jpaQuery).fetch();
		return new PageImpl<>(accounts, pageable, jpaQuery.fetchCount());
	}

	private BooleanExpression eqMemberEmail(String email) {
		if (StringUtils.isEmpty(email)) {
			return null;
		}
		return member.email.eq(email);
	}

	private BooleanExpression eqMemberAddress(String address) {
		if (StringUtils.isEmpty(address)) {
			return null;
		}
		return club.region.eq(address);
	}

	public Optional<Club> fetchClubInfoById(Long clubId) {
		JPAQuery<Club> jpaQuery = new JPAQuery<>(entityManager);

		Club fetchClub = jpaQuery.select(club)
				.from(club)
				.leftJoin(club.myClubs, myClub).fetchJoin()
				.innerJoin(myClub.member, member).fetchJoin()
//				.leftJoin(club.schedule, schedule).fetchJoin()
				.where(eqClubId(clubId))
				.fetchOne();

		return Optional.ofNullable(fetchClub);
	}

	private BooleanExpression eqClubId(Long clubId) {
		if (ObjectUtils.isEmpty(clubId)) {
			return null;
		}
		return club.id.eq(clubId);
	}

	/*public void fetchPagingClubsBySearch(String email, String address, int pageNo) {

	}*/

}
