//package com.youngman.mop.dw;
//
//import com.youngman.mop.domain.board.original.BoardRepository;
//import com.youngman.mop.domain.board.original.Board;
//import com.youngman.mop.domain.board.original.BoardType;
//import com.youngman.mop.domain.board.controller.BoardPagingResponse;
//import com.youngman.mop.domain.board.dw.BoardFetchService;
//import com.youngman.mop.domain.club.command.original.ClubFindDao;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.original.PageRequest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by YoungMan on 2019-06-20.
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class BoardServiceTest {
//
//	@Autowired
//	private BoardFetchService boardFetchService;
//
//	@Autowired
//	private ClubFindDao clubFindDao;
//
//	@Autowired
//	private BoardRepository boardRepository;
//
//
//	@Test
//	public void fetchPagingBoardsByClub() throws Exception {
//
//		//given
//		Long clubId = 1L;
//		int pageNo = 1;
//		PageRequest pageRequest = PageRequest.of(pageNo - 1, 24);
//
//		//when
//		BoardPagingResponse boardPagingResponse = boardFetchService.fetchPagingBoardsByClub(clubId, pageRequest);
//
//		System.out.println(boardPagingResponse);
//		System.out.println(boardPagingResponse);
//	}
//
//	@Test
//	public void insertDummyBoards() throws Exception {
//
//		Long clubId = 1L;
//		List<Board> dummyBoards = new ArrayList<>();
//
//		for (int i = 1; i <= 50; i++) {
//			dummyBoards.add(
//					Board.builder()
//							.boardType(BoardType.POST)
//							.content("content" + i)
//							.title("title" + i)
//							.writer("writer" + i)
//							.club(clubFindDao.findById(clubId))
//							.build()
//			);
//		}
//
//		boardRepository.saveAll(dummyBoards);
//	}
//}
