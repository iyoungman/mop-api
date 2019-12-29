package com.youngman.mop.domain.member.domain;

import com.youngman.mop.domain.common.model.Address;
import com.youngman.mop.domain.common.model.BaseDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by YoungMan on 2019-05-08.
 */

@Entity
@Table(name = "member_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseDate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	@Column(unique = true)
	private String email;

	@Embedded
	private Password password;

	private String name;

	private String mobile;

	@Embedded
	private Address address;

	private String introduce;

	@Embedded
	private FcmToken fcmToken;

	@Builder
	public Member(String email, Password password, String name, String mobile,
				  Address address, String introduce, FcmToken fcmToken) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.introduce = introduce;
		this.fcmToken = fcmToken;
	}

	public void changePassword(String oldPw, String newPw) {
		if (!password.isMatch(oldPw)) {
			throw new IllegalArgumentException();
		}
		password = new Password(newPw);
	}

	public void checkPassword(String inputPw) {
		if (!password.isMatch(inputPw)) {
			throw new IllegalArgumentException();
		}
	}
}
