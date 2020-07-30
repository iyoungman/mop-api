package com.iyoungman.mop.api.domain.schedule.exception;

import com.iyoungman.mop.api.core.exception.BusinessLogicException;
import com.iyoungman.mop.api.core.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-06-20.
 */

public class InvalidMeetingTimeException extends BusinessLogicException {

	public InvalidMeetingTimeException() {
		super(ErrorCodeType.MEETING_TIME_INVALID);
	}
}
