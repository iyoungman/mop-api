package com.youngman.mop.domain.member.domain;

import com.youngman.mop.common.model.Address;
import com.youngman.mop.common.model.BaseDate;
import com.youngman.mop.domain.member.api.dto.MemberCreateRequest;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

	//실명제, 초기에 정하면 바꿀 수 없다.
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

	public void updateMember(MemberCreateRequest memberCreateRequest) {

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
