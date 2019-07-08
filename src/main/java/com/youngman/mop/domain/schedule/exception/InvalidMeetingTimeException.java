package com.youngman.mop.domain.schedule.exception;

import com.youngman.mop.global.error.exception.BusinessLogicException;
import com.youngman.mop.global.error.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-06-20.
 */

public class InvalidMeetingTimeException extends BusinessLogicException {

	public InvalidMeetingTimeException() {
		super(ErrorCodeType.MEETING_TIME_INVALID);
	}
}
