package com.youngman.mop.domain.myclub.exception;

import com.youngman.mop.core.exception.BusinessLogicException;
import com.youngman.mop.core.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-07-11.
 */

public class MyClubAlreadyExistException extends BusinessLogicException {

	public MyClubAlreadyExistException() {
		super(ErrorCodeType.MYCLUB_ALREADY_EXIST);
	}
}
