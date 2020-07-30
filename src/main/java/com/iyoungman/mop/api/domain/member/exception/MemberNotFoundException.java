package com.iyoungman.mop.api.domain.member.exception;

import com.iyoungman.mop.api.core.exception.BusinessLogicException;
import com.iyoungman.mop.api.core.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-06-17.
 */

public class MemberNotFoundException extends BusinessLogicException {

	public MemberNotFoundException() {
		super(ErrorCodeType.MEMBER_NOT_FOUND);
	}
}
