package com.youngman.mop.domain.board.exception;

import com.youngman.mop.core.error.exception.BusinessLogicException;
import com.youngman.mop.core.error.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-06-18.
 */

public class InvalidWriterException extends BusinessLogicException {

	public InvalidWriterException() {
		super(ErrorCodeType.WRITER_INVALID);
	}
}
