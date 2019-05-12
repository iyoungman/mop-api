package com.youngman.mop.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-10.
 */

public class MemberDto {


	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class SignUpRequest {

		private String id;
		private String pw;
		private String name;
		private String mobile;
		private String address;

		@Builder
		public SignUpRequest(String id, String pw, String name, String mobile, String address) {
			this.id = id;
			this.pw = pw;
			this.name = name;
			this.mobile = mobile;
			this.address = address;
		}
	}



}
