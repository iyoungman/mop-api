package com.iyoungman.mop.api.domain.board.exception;

import com.iyoungman.mop.api.core.exception.BusinessLogicException;
import com.iyoungman.mop.api.core.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-06-18.
 */

public class BoardNotFoundException extends BusinessLogicException {

	public BoardNotFoundException() {
		super(ErrorCodeType.BOARD_NOT_FOUND);
	}
}
