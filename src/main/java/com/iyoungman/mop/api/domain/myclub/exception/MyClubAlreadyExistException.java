package com.iyoungman.mop.api.domain.myclub.exception;

import com.iyoungman.mop.api.core.exception.BusinessLogicException;
import com.iyoungman.mop.api.core.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-07-11.
 */

public class MyClubAlreadyExistException extends BusinessLogicException {

	public MyClubAlreadyExistException() {
		super(ErrorCodeType.MYCLUB_ALREADY_EXIST);
	}
}
