package com.youngman.mop.domain.board.application;

import com.youngman.mop.core.jwt.Claim;
import com.youngman.mop.core.jwt.JwtService;
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
public class BoardDeleteService {

    private final BoardRepository boardRepository;

    private final BoardFindDao boardFindDao;

    private final JwtService jwtService;

    public void deleteBoard(Long boardId, String token) {
        String findWriter = boardFindDao.findWriterById(boardId);

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
