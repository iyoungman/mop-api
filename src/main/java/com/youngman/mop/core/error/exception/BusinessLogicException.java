package com.youngman.mop.core.error.exception;

import lombok.Getter;

/**
 * Created by YoungMan on 2019-06-17.
 */

@Getter
public class BusinessLogicException extends RuntimeException {

    private ErrorCodeType errorCodeType;


    public BusinessLogicException(ErrorCodeType errorCodeType) {
        super(errorCodeType.getMessage());
        this.errorCodeType = errorCodeType;
    }

}
