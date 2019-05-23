package com.youngman.mop.exception;

import lombok.Getter;

/**
 * Created by YoungMan on 2019-05-12.
 */

@Getter
public class UserDefineException extends RuntimeException{

	private String originalErrorMessage;

	public UserDefineException(String message) {
		super(message);
	}

	public UserDefineException(String message, String originalErrorMessage) {
		super(message);
		this.originalErrorMessage = originalErrorMessage;
	}
}
