package com.iyoungman.mop.api.domain.board.application;

import com.iyoungman.mop.api.core.jwt.Claim;
import com.iyoungman.mop.api.core.jwt.JwtService;
import com.iyoungman.mop.api.domain.board.domain.BoardRepository;
import com.iyoungman.mop.api.domain.board.exception.InvalidWriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Service
@RequiredArgsConstructor
public class BoardDeleteService {

    private final BoardRepository boardRepository;

    private final JwtService jwtService;

    public void deleteBoard(Long boardId, String token) {
//        String findWriter = boardRepository.findWriterById(boardId).get();
        String findWriter = null;

        Claim claim = jwtService.decode(token);
        String tokenWriter = claim.getName();

        checkValidateWriter(findWriter, tokenWriter);

        boardRepository.deleteById(boardId);
    }

    private void checkValidateWriter(String findWriter, String tokenWriter) {
        if (!findWriter.equals(tokenWriter)) {
            throw new InvalidWriterException();
        }
    }
}
