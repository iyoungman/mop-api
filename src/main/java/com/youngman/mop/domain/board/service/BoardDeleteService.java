package com.youngman.mop.domain.board.service;

import com.youngman.mop.domain.board.dao.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Service
@RequiredArgsConstructor
public class BoardDeleteService {

	private final BoardRepository boardRepository;


	public void deleteBoard(Long boardId) {
		boardRepository.deleteById(boardId);
	}
}
