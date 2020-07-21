package com.youngman.mop.domain.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.youngman.mop.domain.board.BoardValidatorTest.TestClub;
import com.youngman.mop.domain.board.BoardValidatorTest.TestMember;
import com.youngman.mop.domain.board.api.dto.BoardCreateRequest;
import com.youngman.mop.domain.board.application.BoardCreateService;
import com.youngman.mop.domain.board.domain.Board;
import com.youngman.mop.domain.board.domain.BoardRepository;
import com.youngman.mop.domain.board.domain.BoardType;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.domain.ClubRepository;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.domain.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by iyoungman on 2020-07-20.
 */

@Transactional
@SpringBootTest
public class BoardCreateServiceTest {

    @Autowired
    private BoardCreateService boardCreateService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Test
    @DisplayName("게시글 등록 성공 테스트")
    public void createBoard() {
        Member member = memberRepository.save(Member.builder().build());
        Club club = clubRepository.save(Club.builder().build());

        BoardCreateRequest request = BoardCreateRequest.builder()
                .userId(member.getId())
                .clubId(club.getId())
                .boardType(BoardType.POST)
                .content("content")
                .title("title")
                .writer("writer")
                .build();

        Long id = boardCreateService.createBoard(request);
        Board board = boardRepository.findById(id).get();

        assertEquals(request.getBoardType(), board.getBoardType());
        assertEquals(request.getTitle(), board.getBoardItem().getTitle());
        assertEquals(request.getContent(), board.getBoardItem().getContent());
        assertEquals(request.getWriter(), board.getBoardItem().getWriter());
    }
}
