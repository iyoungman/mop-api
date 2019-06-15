package com.youngman.mop.domain.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSignInRequestDto {

	private String email;
	private String pw;


	@Builder
	public MemberSignInRequestDto(String email, String pw) {
		this.email = email;
		this.pw = pw;
	}
}
