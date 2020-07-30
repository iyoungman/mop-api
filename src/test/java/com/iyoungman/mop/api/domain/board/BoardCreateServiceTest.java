package com.iyoungman.mop.api.domain.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.iyoungman.mop.api.domain.board.api.dto.BoardCreateRequest;
import com.iyoungman.mop.api.domain.board.application.BoardCreateService;
import com.iyoungman.mop.api.domain.board.domain.Board;
import com.iyoungman.mop.api.domain.board.domain.BoardRepository;
import com.iyoungman.mop.api.domain.board.domain.BoardType;
import com.iyoungman.mop.api.domain.club.domain.Club;
import com.iyoungman.mop.api.domain.club.domain.ClubRepository;
import com.iyoungman.mop.api.domain.member.domain.Member;
import com.iyoungman.mop.api.domain.member.domain.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
                .clubId(club.getId())
                .boardType(BoardType.POST)
                .content("content")
                .title("title")
                .memberId(member.getId())
                .memberName("writer")
                .build();

        Long id = boardCreateService.createBoard(request);
        Board board = boardRepository.findById(id).get();

        assertEquals(request.getBoardType(), board.getBoardType());
        assertEquals(request.getTitle(), board.getBoardItem().getTitle());
        assertEquals(request.getContent(), board.getBoardItem().getContent());
        assertEquals(request.getMemberName(), board.getWriterName());
    }
}
