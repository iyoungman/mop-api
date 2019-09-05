package com.youngman.mop.board.domain;

import com.youngman.mop.board.exception.BoardNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Service
@RequiredArgsConstructor
public class BoardFindDao {

    private final BoardRepository boardRepository;

    public Board findById(Long id) {
        Optional<Board> board = boardRepository.findById(id);
        board.orElseThrow(BoardNotFoundException::new);
        return board.get();
    }

    public String findWriterById(Long id) {
        Optional<Board> board = boardRepository.findById(id);
        board.orElseThrow(BoardNotFoundException::new);
        return board.get().getWriter();
    }

}
