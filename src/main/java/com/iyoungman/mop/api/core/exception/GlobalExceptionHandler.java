package com.iyoungman.mop.api.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by YoungMan on 2019-05-29.
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity handleBusinessLoginException(BusinessLogicException e) {
        ErrorCodeType codeType = e.getErrorCodeType();
        ErrorResponse response = ErrorResponse.of(codeType);
        return new ResponseEntity<>(response, HttpStatus.valueOf(codeType.getStatus()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnknownException(Exception e) {
        ErrorCodeType codeType = ErrorCodeType.UNKNOWN;
        ErrorResponse response = ErrorResponse.of(codeType);
        return new ResponseEntity<>(response, HttpStatus.valueOf(codeType.getStatus()));
    }

}
