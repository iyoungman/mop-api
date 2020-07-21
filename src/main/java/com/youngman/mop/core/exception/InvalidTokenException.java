package com.youngman.mop.core.exception;

/**
 * Created by iyoungman on 2020-06-30.
 */

public class InvalidTokenException extends BusinessLogicException {

	public InvalidTokenException() {
		super(ErrorCodeType.INVALID_TOKEN);
	}
}
