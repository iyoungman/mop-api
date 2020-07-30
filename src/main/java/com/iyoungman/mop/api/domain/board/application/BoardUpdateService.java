package com.iyoungman.mop.api.domain.board.application;

import com.iyoungman.mop.api.core.jwt.Claim;
import com.iyoungman.mop.api.core.jwt.JwtService;
import com.iyoungman.mop.api.domain.board.api.dto.BoardUpdateRequest;
import com.iyoungman.mop.api.domain.board.domain.Board;
import com.iyoungman.mop.api.domain.board.domain.BoardRepository;
import com.iyoungman.mop.api.domain.board.exception.InvalidWriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Service
@RequiredArgsConstructor
public class BoardUpdateService {

    private final BoardRepository boardRepository;

    private final JwtService jwtService;

    public void updateBoard(BoardUpdateRequest boardUpdateRequest, String token) {
        Board board = boardRepository.findById(boardUpdateRequest.getBoardId()).get();

        Claim claim = jwtService.decode(token);
        board.checkWriter(claim.getId());

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
