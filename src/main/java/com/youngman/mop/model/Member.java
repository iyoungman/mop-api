package com.youngman.mop.model;

import com.youngman.mop.model.dto.SignUpRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-08.
 */

@Entity
@Table(name = "member_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	@Column(unique = true)
	private String email;

	private String pw;

	private String name;

	private String mobile;

	private String address;

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
	private List<MyClub> myClubs = new ArrayList<>();


	@Builder
	public Member(String email, String pw, String name, String mobile, String address) {
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
	}

	public static Member of(SignUpRequestDto signUpRequestDto) {
		return Member.builder()
				.email(signUpRequestDto.getEmail())
				.pw(signUpRequestDto.getPw())
				.name(signUpRequestDto.getName())
				.mobile(signUpRequestDto.getMobile())
				.address(signUpRequestDto.getAddress())
				.build();
	}

	public void updateMember(SignUpRequestDto signUpRequestDto) {
//		this.email = signUpRequestDto.getEmail();
		this.pw = signUpRequestDto.getPw();
		this.name = signUpRequestDto.getName();
		this.mobile = signUpRequestDto.getMobile();
		this.address = signUpRequestDto.getAddress();
	}

}
