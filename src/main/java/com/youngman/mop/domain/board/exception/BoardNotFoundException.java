package com.youngman.mop.domain.board.exception;

import com.youngman.mop.global.error.exception.BusinessLogicException;
import com.youngman.mop.global.error.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-06-18.
 */

public class BoardNotFoundException extends BusinessLogicException {

	public BoardNotFoundException() {
		super(ErrorCodeType.BOARD_NOT_FOUND);
	}
}
