package com.iyoungman.mop.api.domain.board.application;

import com.iyoungman.mop.api.domain.board.api.dto.BoardCreateRequest;
import com.iyoungman.mop.api.domain.board.domain.Board;
import com.iyoungman.mop.api.domain.board.domain.BoardRepository;
import com.iyoungman.mop.api.domain.board.domain.BoardValidator;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Service
@Transactional
@RequiredArgsConstructor
public class BoardCreateService {

    private final BoardRepository boardRepository;

    private final BoardValidator boardValidator;

    public Long createBoard(BoardCreateRequest boardCreateRequest) {
        Board board = boardCreateRequest.toEntity();
        board.check(boardValidator);
        return boardRepository.save(board).getId();
    }
}
