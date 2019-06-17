package com.youngman.mop.domain.club.exception;

import com.youngman.mop.global.error.exception.BusinessLogicException;
import com.youngman.mop.global.error.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-06-17.
 */

public class ClubNotFoundException extends BusinessLogicException {

	public ClubNotFoundException() {
		super(ErrorCodeType.CLUB_NOT_FOUND);
	}
}
