package com.youngman.mop.domain.board.application;

import com.youngman.mop.domain.board.domain.BoardRepository;
import com.youngman.mop.domain.board.domain.Board;
import com.youngman.mop.domain.board.domain.BoardValidator;
import com.youngman.mop.domain.board.api.dto.BoardCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Service
@Transactional
@RequiredArgsConstructor
public class BoardCreateService {

    private final BoardRepository boardRepository;
    private final BoardValidator boardValidator;

    public void createBoard(BoardCreateRequest boardCreateRequest) {
        Board board = boardCreateRequest.toEntity();
        board.check(boardValidator);
        boardRepository.save(board);
    }
}
