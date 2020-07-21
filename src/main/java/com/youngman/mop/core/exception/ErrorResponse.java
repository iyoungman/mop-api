package com.youngman.mop.core.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by YoungMan on 2019-05-29.
 */

@Getter
@Setter
public class ErrorResponse {

    private String code;
    private String message;


    @Builder
    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorResponse of(ErrorCodeType errorCodeType) {
        return ErrorResponse.builder()
                .code(errorCodeType.getCode())
                .message(errorCodeType.getMessage())
                .build();
    }
}