package com.youngman.mop.domain.member.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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
