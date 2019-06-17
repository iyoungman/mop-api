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

	@Autowired
	private UrlPathHelper urlPathHelper;


	@ExceptionHandler(BusinessLogicException.class)
	public ResponseEntity handleBusinessLoginException(HttpServletRequest request, BusinessLogicException e) {
		printHttpRequestLog(request);
		printBusinessLogicExceptionLog(e);

		ErrorCodeType codeType = e.getErrorCodeType();
		ErrorResponse response = ErrorResponse.of(codeType);
		return new ResponseEntity<>(response, HttpStatus.valueOf(codeType.getStatus()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleUnknownException(HttpServletRequest request, Exception e) {
		printHttpRequestLog(request);
		printUnknownExceptionLog(e);

		ErrorCodeType codeType = ErrorCodeType.UNKNOWN;
		ErrorResponse response = ErrorResponse.of(codeType);
		return new ResponseEntity<>(response, HttpStatus.valueOf(codeType.getStatus()));
	}


	private void printHttpRequestLog(HttpServletRequest request) {
		String requestURL = urlPathHelper.getOriginatingRequestUri(request);
		log.info("==============Exception Log Start================");
		log.info("");
		log.info("예외 발생 시간 => {}", LocalDateTime.now());
		log.info("HTTP Request 메소드 => {}", request.getMethod());
		log.info("HTTP Request URL => " + requestURL);
		log.info("Client => {}", request.getRemoteHost());
	}

	private void printBusinessLogicExceptionLog(BusinessLogicException e) {
		log.info("BusinessLogicException => {}", e.getMessage());
		log.info("OriginalErrorMessage => {}", e.getErrorCodeType().getMessage());
		log.info("");
		log.info("==============Exception Log End=================");
	}

	private void printUnknownExceptionLog(Exception e) {
		log.info("UserDefineErrorMessage => {}", "UnKnown Exception");
		log.info("OriginalErrorMessage => {}", e.getMessage());
		log.info("");
		log.info("==============Exception Log End=================");
	}

}
