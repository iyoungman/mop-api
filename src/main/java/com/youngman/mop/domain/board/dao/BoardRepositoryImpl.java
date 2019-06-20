package com.youngman.mop.domain.board.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.youngman.mop.domain.board.domain.Board;
import com.youngman.mop.domain.board.domain.BoardType;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Objects;

import static com.youngman.mop.domain.board.domain.QBoard.board;
import static com.youngman.mop.domain.club.domain.QClub.club;

/**
 * Created by YoungMan on 2019-06-20.
 */

@Component
public class BoardRepositoryImpl extends QuerydslRepositorySupport implements BoardRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public BoardRepositoryImpl() {
		super(Board.class);
	}


	@Override
	public Page<Board> fetchPagingBoardsByClub(Long clubId, PageRequest pageable) {
		JPAQuery<Board> jpaQuery = new JPAQuery<>(entityManager);

		jpaQuery = jpaQuery.from(board)
				.innerJoin(board.club, club)
				.where(eqClubId(clubId))
				.orderBy(board.boardType.asc(), board.id.desc());

		List<Board> boards = Objects.requireNonNull(getQuerydsl()).applyPagination(pageable, jpaQuery).fetch();
		return new PageImpl<>(boards, pageable, jpaQuery.fetchCount());
	}

	private BooleanExpression eqClubId(Long clubId) {
		if (ObjectUtils.isEmpty(clubId)) {
			return null;
		}
		return club.id.eq(clubId);
	}

	private BooleanExpression eqNotice() {
		return board.boardType.eq(BoardType.NOTICE);
	}
}
