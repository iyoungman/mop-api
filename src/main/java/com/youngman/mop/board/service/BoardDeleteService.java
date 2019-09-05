package com.youngman.mop.board.service;

import com.youngman.mop.board.domain.BoardFindDao;
import com.youngman.mop.board.domain.BoardRepository;
import com.youngman.mop.board.exception.InvalidWriterException;
import com.youngman.mop.global.jwt.JwtService;
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
        String tokenWriter = jwtService.findNameByJwt(token);
        checkValidateWriter(findWriter, tokenWriter);

        boardRepository.deleteById(boardId);
    }

    private void checkValidateWriter(String findWriter, String tokenWriter) {
        if (!findWriter.equals(tokenWriter)) {
            throw new InvalidWriterException();
        }
    }
}
