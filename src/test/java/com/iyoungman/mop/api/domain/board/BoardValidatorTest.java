package com.iyoungman.mop.api.domain.board;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.iyoungman.mop.api.common.model.Writer;
import com.iyoungman.mop.api.domain.board.domain.Board;
import com.iyoungman.mop.api.domain.board.domain.BoardItem;
import com.iyoungman.mop.api.domain.board.domain.BoardType;
import com.iyoungman.mop.api.domain.board.domain.BoardValidator;
import com.iyoungman.mop.api.domain.club.domain.Club;
import com.iyoungman.mop.api.domain.club.domain.ClubRepository;
import com.iyoungman.mop.api.domain.member.domain.Member;
import com.iyoungman.mop.api.domain.member.domain.MemberRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by iyoungman on 2020-07-20.
 */

@Transactional
@ExtendWith(MockitoExtension.class)
public class BoardValidatorTest {

    @InjectMocks
    private BoardValidator boardValidator;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private ClubRepository clubRepository;

    @BeforeEach
    public void init() {
        when(memberRepository.findById(1L)).thenReturn(Optional.of(new TestMember()));
        when(clubRepository.findById(1L)).thenReturn(Optional.of(new TestClub()));
    }

    @Test
    @DisplayName("올바른 Board 객체 검증")
    public void validateCorrectBoard() {
        Long memberId = 1L;
        Long clubId = 1L;

        BoardItem boardItem = BoardItem.builder()
                .title("title")
                .content("content")
                .boardType(BoardType.POST)
                .build();

        Writer writer = new Writer(memberId, "Writer");

        Board board = Board.builder()
                .writer(writer)
                .clubId(clubId)
                .boardItem(boardItem)
                .build();

        boardValidator.validate(board);
    }

    @Test
    @DisplayName("연관된 MemberId or ClubId가 존재하지 않는 Board 객체 검증")
    public void validateWrongBoard() {
        Long memberId = 2L;
        Long clubId = 2L;

        BoardItem boardItem = BoardItem.builder()
                .title("title")
                .content("content")
                .boardType(BoardType.POST)
                .build();

        Writer writer = new Writer(memberId, "Writer");

        Board board = Board.builder()
                .writer(writer)
                .clubId(clubId)
                .boardItem(boardItem)
                .build();

        assertThrows(RuntimeException.class, () -> boardValidator.validate(board));
    }

    static class TestMember extends Member {

    }

    static class TestClub extends Club {

    }
}
