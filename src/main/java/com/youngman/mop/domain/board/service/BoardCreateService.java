package com.youngman.mop.domain.board.service;

import com.youngman.mop.domain.board.dao.BoardRepository;
import com.youngman.mop.domain.board.domain.Board;
import com.youngman.mop.domain.board.dto.BoardCreateRequest;
import com.youngman.mop.domain.club.dao.ClubFindDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Service
@RequiredArgsConstructor
public class BoardCreateService {

	private final BoardRepository boardRepository;
	private final ClubFindDao clubFindDao;


	public void createBoard(BoardCreateRequest boardCreateRequest) {
		Board createBoard = Board.of(boardCreateRequest, clubFindDao.findById(boardCreateRequest.getClubId()));
		boardRepository.save(createBoard);
	}
}
