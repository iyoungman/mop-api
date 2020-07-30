package com.iyoungman.mop.api.domain.board;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.iyoungman.mop.api.core.jwt.JwtService;
import com.iyoungman.mop.api.domain.board.api.dto.BoardCreateRequest;
import com.iyoungman.mop.api.domain.board.application.BoardDeleteService;
import com.iyoungman.mop.api.domain.board.domain.Board;
import com.iyoungman.mop.api.domain.board.domain.BoardRepository;
import com.iyoungman.mop.api.domain.board.domain.BoardType;
import org.junit.jupiter.api.BeforeEach;
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
public class BoardDeleteServiceTest {

    @Autowired
    private BoardDeleteService boardDeleteService;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private JwtService jwtService;

    private Long id;

    private String token;

    @BeforeEach
    public void init() {
        String writer = "iyoungman";

        //Board
        BoardCreateRequest request = BoardCreateRequest.builder()
                .boardType(BoardType.POST)
                .content("content")
                .title("title")
                .memberName(writer)
                .build();

        Board board = request.toEntity();
        id = boardRepository.save(board).getId();

        //Token
        token = jwtService.encode(1L, writer, writer);
    }

    @Test
    @DisplayName("게시글 정상 삭제")
    public void deleteBoard() {
        boardDeleteService.deleteBoard(id, token);

        boolean result = boardRepository.findById(id).isPresent();
        assertFalse(result);
    }
}
