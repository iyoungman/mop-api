package com.youngman.mop.domain.member.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * Created by YoungMan on 2019-05-23.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberCreateRequest {

	private String email;
	private String pw;
	private String name;
	private String mobile;
	private String address;
	private String fcmToken;


	@Builder
	public MemberCreateRequest(String email, String pw, String name,
							   String mobile, String address, String fcmToken) {
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.fcmToken = fcmToken;
	}
}
