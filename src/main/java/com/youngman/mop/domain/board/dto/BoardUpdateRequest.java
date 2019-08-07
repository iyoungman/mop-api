package com.youngman.mop.domain.board.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-06-18.
 * Update 할 수 있는것 중 그전 내용들 다 받기
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardUpdateRequest {

	private Long boardId;
	private String title;
	private String content;


	@Builder
	public BoardUpdateRequest(Long boardId, String title, String content) {
		this.boardId = boardId;
		this.title = title;
		this.content = content;
	}
}
