package com.youngman.mop.domain.board.api;

import com.youngman.mop.domain.board.api.dto.BoardCreateRequest;
import com.youngman.mop.domain.board.api.dto.BoardPagingResponse;
import com.youngman.mop.domain.board.api.dto.BoardUpdateRequest;
import com.youngman.mop.domain.board.application.BoardCreateService;
import com.youngman.mop.domain.board.application.BoardDeleteService;
import com.youngman.mop.domain.board.application.BoardFindService;
import com.youngman.mop.domain.board.application.BoardUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mop/board")
public class BoardController {

    private final BoardCreateService boardCreateService;
    private final BoardFindService boardFetchService;
    private final BoardUpdateService boardUpdateService;
    private final BoardDeleteService boardDeleteService;

    @PostMapping
    public void createBoard(@RequestBody BoardCreateRequest boardCreateRequest) {
        boardCreateService.createBoard(boardCreateRequest);
    }

    @GetMapping
    public BoardPagingResponse fetchPagingBoardsByClub(@RequestParam("clubId") Long clubId,
                                                       @RequestParam("pageNo") int pageNo) {
        return boardFetchService.fetchPagingBoardsByClub(clubId, PageRequest.of(pageNo - 1, 24));
    }

    @PutMapping
    public void updateBoard(@RequestBody BoardUpdateRequest boardUpdateRequest,
                            @RequestHeader("token") String token) {
        boardUpdateService.updateBoard(boardUpdateRequest, token);
    }

    @DeleteMapping
    public void deleteBoard(@RequestParam("boardId") Long boardId,
                            @RequestHeader("token") String token) {
        boardDeleteService.deleteBoard(boardId, token);
    }
}
