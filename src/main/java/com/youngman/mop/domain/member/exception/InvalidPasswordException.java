package com.youngman.mop.domain.member.exception;

import com.youngman.mop.core.error.exception.BusinessLogicException;
import com.youngman.mop.core.error.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-06-17.
 */

public class InvalidPasswordException extends BusinessLogicException {

	public InvalidPasswordException() {
		super(ErrorCodeType.PASSWORD_INVALID);
	}
}
