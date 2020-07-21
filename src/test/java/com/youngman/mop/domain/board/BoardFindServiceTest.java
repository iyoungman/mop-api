package com.youngman.mop.domain.board;

import com.youngman.mop.domain.board.api.dto.BoardPagingResponse;
import com.youngman.mop.domain.board.application.BoardFindService;
import com.youngman.mop.domain.board.domain.Board;
import com.youngman.mop.domain.board.domain.BoardItem;
import com.youngman.mop.domain.board.domain.BoardRepository;
import com.youngman.mop.domain.board.domain.BoardType;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.domain.ClubRepository;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by iyoungman on 2020-07-20.
 */

@Transactional
@SpringBootTest
public class BoardFindServiceTest {

    private static final int SIZE = 12;

    @Autowired
    private BoardFindService boardFindService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ClubRepository clubRepository;

    private Long clubId;

    @BeforeEach
    public void init() {
        clubId = clubRepository.save(Club.builder().build()).getId();

        //공지사항
        List<Board> boardsOfNotice = Lists.newArrayList();
        for(int i = 0; i < SIZE; i++) {
            BoardItem item = BoardItem.builder()
                    .boardType(BoardType.NOTICE)
                    .build();

            Board board = Board.builder()
                    .boardItem(item)
                    .clubId(clubId)
                    .build();

            boardsOfNotice.add(board);
        }

        //게시글
        List<Board> boardsOfPost = Lists.newArrayList();
        for(int i = 0; i < SIZE; i++) {
            BoardItem item = BoardItem.builder()
                    .boardType(BoardType.POST)
                    .build();

            Board board = Board.builder()
                    .boardItem(item)
                    .clubId(clubId)
                    .build();

            boardsOfPost.add(board);
        }

        boardRepository.saveAll(boardsOfNotice);
        boardRepository.saveAll(boardsOfPost);
    }

    @Test
    @DisplayName("게시글 페이징 처리 정상 확인")
    public void fetchPagingBoardsCorrectByClub() {
        int pageNo = 1;
        PageRequest request = PageRequest.of(pageNo - 1, 24);

        BoardPagingResponse response = boardFindService.fetchPagingBoardsByClub(clubId, request);

        Assertions.assertFalse(response.isEmpty());
        Assertions.assertTrue(response.isLast());
        Assertions.assertEquals(SIZE, response.getNotices().size());
        Assertions.assertEquals(SIZE, response.getPosts().size());
    }

    @Test
    @DisplayName("게시글 페이징 Empty 확인")
    public void fetchPagingBoardsEmptyByClub() {
        int pageNo = 2;
        PageRequest request = PageRequest.of(pageNo - 1, 24);

        BoardPagingResponse response = boardFindService.fetchPagingBoardsByClub(clubId, request);

        Assertions.assertTrue(response.isEmpty());
    }
}
