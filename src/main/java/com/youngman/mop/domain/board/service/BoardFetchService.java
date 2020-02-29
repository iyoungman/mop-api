package com.youngman.mop.domain.board.service;

import com.youngman.mop.domain.board.domain.BoardRepository;
import com.youngman.mop.domain.board.domain.Board;
import com.youngman.mop.domain.board.domain.BoardType;
import com.youngman.mop.domain.board.controller.dto.BoardPagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Service
@RequiredArgsConstructor
public class BoardFetchService {

    private final BoardRepository boardRepository;


    /**
     * 첫 페이지일 경우 공지사항 개수 + 게시글 개수 = 24
     */
    public BoardPagingResponse fetchPagingBoardsByClub(Long clubId, PageRequest pageable) {
        Page<Board> pagingBoard = boardRepository.fetchPagingBoardsByClub(clubId, pageable);

        return BoardPagingResponse.builder()
                .isLast(pagingBoard.isLast())
                .isEmpty(pagingBoard.isLast())
                .notices(fetchNotice(pagingBoard.getContent()))
                .posts(fetchPost(pagingBoard.getContent()))
                .build();
    }

    private List<Board> fetchNotice(List<Board> boards) {
        return boards.stream()
                .filter(i -> i.getBoardType().equals(BoardType.NOTICE))
                .collect(Collectors.toList());
    }

    private List<Board> fetchPost(List<Board> boards) {
        return boards.stream()
                .filter(i -> i.getBoardType().equals(BoardType.POST))
                .collect(Collectors.toList());
    }
}
