package com.youngman.mop.domain.board.service;

import com.youngman.mop.domain.board.dao.BoardRepository;
import com.youngman.mop.domain.board.domain.Board;
import com.youngman.mop.domain.board.dto.BoardCreateRequest;
import com.youngman.mop.domain.club.dao.ClubFindDao;
import com.youngman.mop.domain.club.domain.Club;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Service
@RequiredArgsConstructor
public class BoardCreateService {

    private final BoardRepository boardRepository;
    private final ClubFindDao clubFindDao;

    @Transactional
    public void createBoard(BoardCreateRequest boardCreateRequest) {
        Club club = clubFindDao.findById(boardCreateRequest.getClubId());
        Board board = boardCreateRequest.toEntity(club);
        boardRepository.save(board);
    }
}
