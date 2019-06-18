package com.youngman.mop.domain.board.service;

import com.youngman.mop.domain.board.dao.BoardRepository;
import com.youngman.mop.domain.board.dto.BoardPagingResponse;
import com.youngman.mop.domain.club.dto.ClubPagingResponse;
import com.youngman.mop.domain.myclub.dto.MyClubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Service
@RequiredArgsConstructor
public class BoardFetchService {

	private final BoardRepository boardRepository;


	/**
	 * 첫 페이지일 경우 공지사항 개수 + 게시글 개수 = 24
	 */
	public BoardPagingResponse fetchPagingBoardsByClub(Long clubId, PageRequest pageable) {
//		Page<MyClubResponse> pagingMyClubResponseDto = clubRepository.fetchPagingClubsByMember(email,
//				memberFindDao.findAddressByEmail(email), pageable);
//
//		return ClucbPagingResponse.of(pagingMyClubResponseDto);
	}
}
