package com.youngman.mop.member.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * Created by YoungMan on 2019-12-23.
 */

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FcmToken {

	private String fcmToken;

	public FcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	public boolean isMatch(String fcmToken) {
		return this.fcmToken.equals(fcmToken);
	}
}
