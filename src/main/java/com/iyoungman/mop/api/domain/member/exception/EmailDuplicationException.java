package com.iyoungman.mop.api.domain.member.exception;

import com.iyoungman.mop.api.core.exception.BusinessLogicException;
import com.iyoungman.mop.api.core.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-06-17.
 */

public class EmailDuplicationException extends BusinessLogicException {

	public EmailDuplicationException() {
		super(ErrorCodeType.EMAIL_DUPLICATION);
	}
}
