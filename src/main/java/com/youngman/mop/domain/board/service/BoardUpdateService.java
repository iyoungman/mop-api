package com.youngman.mop.domain.board.service;

import com.youngman.mop.domain.board.dao.BoardFindDao;
import com.youngman.mop.domain.board.dao.BoardRepository;
import com.youngman.mop.domain.board.domain.Board;
import com.youngman.mop.domain.board.dto.BoardUpdateRequest;
import com.youngman.mop.domain.board.exception.InvalidWriterException;
import com.youngman.mop.global.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Service
@RequiredArgsConstructor
public class BoardUpdateService {

	private final BoardRepository boardRepository;
	private final BoardFindDao boardFindDao;
	private final JwtService jwtService;


	public void updateBoard(BoardUpdateRequest boardUpdateRequest, String token) {
		Board board = boardFindDao.findById(boardUpdateRequest.getBoardId());
		checkValidateWriter(board.getWriter(), jwtService.findNameByJwt(token));
		board.updateBoard(boardUpdateRequest.getTitle(), boardUpdateRequest.getContent());
		boardRepository.save(board);
	}

	private void checkValidateWriter(String boardWriterName, String updateWriterName) {
		if(boardWriterName.equals(updateWriterName)) {
			return;
		}
		throw new InvalidWriterException();
	}
}
