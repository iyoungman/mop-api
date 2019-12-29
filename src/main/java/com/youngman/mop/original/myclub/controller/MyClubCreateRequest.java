package com.youngman.mop.original.myclub.controller;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyClubCreateRequest {

	private String email;
	private Long clubId;


	@Builder
	public MyClubCreateRequest(String email, Long clubId) {
		this.email = email;
		this.clubId = clubId;
	}
}
