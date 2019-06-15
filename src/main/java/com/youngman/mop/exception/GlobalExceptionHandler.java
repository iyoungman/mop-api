package com.youngman.mop.exception;

import com.youngman.mop.domain.dto.ErrorResponseDto;
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


	@ExceptionHandler(UserDefineException.class)
	public ResponseEntity handleUserDefineException(HttpServletRequest request, UserDefineException exception) {
		printHttpRequestLog(request);
		printUserDefineExceptionLog(exception);

		return new ResponseEntity<>(ErrorResponseDto.builder()
				.userDefineErrorMessage(exception.getMessage())
				.originalErrorMessage(exception.getOriginalErrorMessage())
				.build(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity handleUnknownException(HttpServletRequest request, Exception exception) {
		printHttpRequestLog(request);
		printUnknownExceptionLog(exception);

		return new ResponseEntity<>(ErrorResponseDto.builder()
				.userDefineErrorMessage("UnKnown Exception")
				.originalErrorMessage(exception.toString())
				.build(), HttpStatus.BAD_REQUEST);
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

	private void printUserDefineExceptionLog(UserDefineException exception) {
		log.info("UserDefineErrorMessage => {}", exception.getMessage());
		log.info("OriginalErrorMessage => {}", exception.getOriginalErrorMessage());
		log.info("");
		log.info("==============Exception Log End=================");
	}

	private void printUnknownExceptionLog(Exception exception) {
		log.info("UserDefineErrorMessage => {}", "UnKnown Exception");
		log.info("OriginalErrorMessage => {}", exception.getMessage());
		log.info("");
		log.info("==============Exception Log End=================");
	}

}
