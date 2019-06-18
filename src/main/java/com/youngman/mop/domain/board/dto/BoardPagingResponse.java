package com.youngman.mop.domain.board.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardPagingResponse {

	private boolean isLast;
	private boolean isEmpty;
	//공지사항
	//게시판글
}
