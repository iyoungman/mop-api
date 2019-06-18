package com.youngman.mop.domain.board.dto;

import com.youngman.mop.domain.board.domain.BoardType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardCreateRequest {

	private String title;
	private String content;
	private String writer;
	private BoardType boardType;
	private Long clubId;


	@Builder
	public BoardCreateRequest(String title, String content, String writer,
							  BoardType boardType, Long clubId) {

		this.title = title;
		this.content = content;
		this.writer = writer;
		this.boardType = boardType;
		this.clubId = clubId;
	}
}
