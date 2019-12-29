package com.youngman.mop.original.board;

import com.youngman.mop.domain.board.controller.BoardCreateRequest;
import com.youngman.mop.domain.board.domain.Board;
import com.youngman.mop.domain.board.domain.BoardRepository;
import com.youngman.mop.domain.board.domain.BoardType;
import com.youngman.mop.domain.board.service.BoardCreateService;
import com.youngman.mop.domain.club.command.domain.Club;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by YoungMan on 2019-08-09.
 */

@NoArgsConstructor
@ExtendWith(SpringExtension.class)
class BoardCreateServiceTest {

    @InjectMocks
    private BoardCreateService boardCreateService;

    @Mock
    private BoardRepository boardRepository;

    @Mock
    private ClubFindDao clubFindDao;

    private Long CLUB_ID = 1L;
    private Club club;
    private BoardCreateRequest boardCreateRequest;
    private Board board;


    @BeforeEach
    void setUp() {
        club = Club.builder()
                .name("name")
                .region("region")
                .chairEmail("chairEmail")
                .hobby("hobby")
                .introduce("introduce")
                .build();

        boardCreateRequest = BoardCreateRequest.builder()
                .clubId(CLUB_ID)
                .title("title")
                .writer("writer")
                .content("content")
                .boardType(BoardType.POST)
                .build();

        board = boardCreateRequest.toEntity(club);
    }

    @Test
    void 게시글_저장() {
        //given
        when(clubFindDao.findById(CLUB_ID)).thenReturn(club);
        when(boardRepository.save(board)).thenReturn(board);

        //when
        boardCreateService.createBoard(boardCreateRequest);

        //then
        verify(boardRepository).save(refEq(board));
    }
}
