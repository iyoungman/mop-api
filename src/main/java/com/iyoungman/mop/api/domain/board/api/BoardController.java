package com.iyoungman.mop.api.domain.board.api;

import com.iyoungman.mop.api.domain.board.api.dto.BoardCreateRequest;
import com.iyoungman.mop.api.domain.board.api.dto.BoardPagingResponse;
import com.iyoungman.mop.api.domain.board.api.dto.BoardUpdateRequest;
import com.iyoungman.mop.api.domain.board.application.BoardCreateService;
import com.iyoungman.mop.api.domain.board.application.BoardDeleteService;
import com.iyoungman.mop.api.domain.board.application.BoardFindService;
import com.iyoungman.mop.api.domain.board.application.BoardUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
