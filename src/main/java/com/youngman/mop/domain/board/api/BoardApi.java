package com.youngman.mop.domain.board.api;

import com.youngman.mop.domain.board.dto.BoardPagingResponse;
import com.youngman.mop.domain.board.service.BoardFetchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
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
public class BoardApi {

	private final BoardFetchService boardFetchService;


	@GetMapping("/club")
	public BoardPagingResponse fetchPagingBoardsByClub(@RequestParam("clubId") Long clubId,
													   @RequestParam("pageNo") int pageNo) {

		return boardFetchService.fetchPagingBoardsByClub(clubId, PageRequest.of(pageNo - 1, 24));
	}
}
