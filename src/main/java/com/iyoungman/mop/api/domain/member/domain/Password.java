package com.iyoungman.mop.api.domain.member.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-12-23.
 */

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Password {

	@Column(name = "password")
	private String password;

	public Password(String password) {
		this.password = password;
	}

	public boolean isMatch(String password) {
		return this.password.equals(password);
	}
}
