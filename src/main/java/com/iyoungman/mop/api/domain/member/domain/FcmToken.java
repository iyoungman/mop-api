package com.iyoungman.mop.api.domain.member.domain;

import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
