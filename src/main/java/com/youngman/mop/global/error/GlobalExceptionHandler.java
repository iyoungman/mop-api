package com.youngman.mop.global.error;

import com.youngman.mop.global.error.exception.BusinessLogicException;
import com.youngman.mop.global.error.exception.ErrorCodeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

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
