package com.youngman.mop.domain.member.exception;

import com.youngman.mop.core.error.exception.BusinessLogicException;
import com.youngman.mop.core.error.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-06-17.
 */

public class MemberNotFoundException extends BusinessLogicException {

	public MemberNotFoundException() {
		super(ErrorCodeType.MEMBER_NOT_FOUND);
	}
}
