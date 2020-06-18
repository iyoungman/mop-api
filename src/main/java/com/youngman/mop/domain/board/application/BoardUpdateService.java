package com.youngman.mop.domain.board.application;

import com.youngman.mop.core.jwt.Claim;
import com.youngman.mop.core.jwt.JwtService;
import com.youngman.mop.domain.board.api.dto.BoardUpdateRequest;
import com.youngman.mop.domain.board.domain.Board;
import com.youngman.mop.domain.board.domain.BoardFindDao;
import com.youngman.mop.domain.board.domain.BoardRepository;
import com.youngman.mop.domain.board.exception.InvalidWriterException;
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

        Claim claim = jwtService.decode(token);
        board.checkWriter(claim.getName());

        board.updateBoardItem(boardUpdateRequest.getTitle(), boardUpdateRequest.getContent());
        boardRepository.save(board);
    }

    private void checkValidateWriter(String boardWriterName, String updateWriterName) {
        if (boardWriterName.equals(updateWriterName)) {
            return;
        }
        throw new InvalidWriterException();
    }
}
