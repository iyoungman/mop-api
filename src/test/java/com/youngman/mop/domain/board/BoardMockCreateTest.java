package com.youngman.mop.domain.board;

import com.youngman.mop.domain.board.domain.BoardType;
import com.youngman.mop.domain.board.dto.BoardCreateRequest;
import com.youngman.mop.domain.board.service.BoardCreateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Created by YoungMan on 2019-10-25.
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BoardMockCreateTest {

    @Autowired
    private BoardCreateService boardCreateService;

    @Test
    public void createMockData() {
        for (int i = 1; i <= 50; i++) {
            BoardCreateRequest boardCreateRequest = BoardCreateRequest.builder()
                    .title("title" + i)
                    .content("content" + i)
                    .writer("이영준")
                    .boardType(BoardType.POST)
                    .clubId(1L)
                    .build();

            boardCreateService.createBoard(boardCreateRequest);
        }

    }
}
