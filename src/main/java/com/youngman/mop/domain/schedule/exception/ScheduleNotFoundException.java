package com.youngman.mop.domain.schedule.exception;

import com.youngman.mop.core.exception.BusinessLogicException;
import com.youngman.mop.core.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-06-20.
 */

public class ScheduleNotFoundException extends BusinessLogicException {

	public ScheduleNotFoundException() {
		super(ErrorCodeType.SCHEDULE_NOT_FOUND);
	}
}
