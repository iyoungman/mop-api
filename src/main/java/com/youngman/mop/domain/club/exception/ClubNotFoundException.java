package com.youngman.mop.domain.club.exception;

import com.youngman.mop.core.exception.BusinessLogicException;
import com.youngman.mop.core.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-06-17.
 */

public class ClubNotFoundException extends BusinessLogicException {

    public ClubNotFoundException() {
        super(ErrorCodeType.CLUB_NOT_FOUND);
    }
}
