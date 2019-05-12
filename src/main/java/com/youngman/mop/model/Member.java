package com.youngman.mop.model;

import com.youngman.mop.model.dto.MemberDto;
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
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String pw;

	private String name;

	private String mobile;

	private String address;


	@Builder
	public Member(String id, String pw, String name, String mobile, String address) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
	}

	public static Member of(MemberDto.SignUpRequest signUpRequest) {
		return Member.builder()
				.id(signUpRequest.getId())
				.pw(signUpRequest.getPw())
				.name(signUpRequest.getName())
				.mobile(signUpRequest.getMobile())
				.address(signUpRequest.getAddress())
				.build();
	}

	public void updateMember(MemberDto.SignUpRequest signUpRequest) {
		this.id = signUpRequest.getId();
		this.pw = signUpRequest.getPw();
		this.name = signUpRequest.getName();
		this.mobile = signUpRequest.getMobile();
		this.address = signUpRequest.getAddress();
	}

	//Club에 가입한다




}
