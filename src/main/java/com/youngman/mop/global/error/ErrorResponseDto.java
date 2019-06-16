package com.youngman.mop.global.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by YoungMan on 2019-05-29.
 */

@Getter
@Setter
public class ErrorResponseDto {

	private String userDefineErrorMessage;
	private String originalErrorMessage;


	@Builder
	public ErrorResponseDto(String userDefineErrorMessage, String originalErrorMessage) {
		this.userDefineErrorMessage = userDefineErrorMessage;
		this.originalErrorMessage = originalErrorMessage;
	}
}