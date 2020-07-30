package com.iyoungman.mop.api.domain.club.exception;

import com.iyoungman.mop.api.core.exception.BusinessLogicException;
import com.iyoungman.mop.api.core.exception.ErrorCodeType;

/**
 * Created by YoungMan on 2019-06-17.
 */

public class ClubNotFoundException extends BusinessLogicException {

    public ClubNotFoundException() {
        super(ErrorCodeType.CLUB_NOT_FOUND);
    }
}
