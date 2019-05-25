package com.youngman.mop.model.domain;

import com.youngman.mop.model.dto.MemberCreateRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-08.
 */

@Entity
@Table(name = "member_tbl")
@Getter
@EntityListeners(AuditingEntityListener.class)
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

	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate createDate;

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
	private List<MyClub> myClubs = new ArrayList<>();

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
	private List<MyHobby> myHobbies = new ArrayList<>();

	@Builder
	public Member(String email, String pw, String name, String mobile, String address) {
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
	}

	public static Member of(MemberCreateRequestDto memberCreateRequestDto) {
		return Member.builder()
				.email(memberCreateRequestDto.getEmail())
				.pw(memberCreateRequestDto.getPw())
				.name(memberCreateRequestDto.getName())
				.mobile(memberCreateRequestDto.getMobile())
				.address(memberCreateRequestDto.getAddress())
				.build();
	}

	public void updateMember(MemberCreateRequestDto memberCreateRequestDto) {
		this.pw = memberCreateRequestDto.getPw();
		this.name = memberCreateRequestDto.getName();
		this.mobile = memberCreateRequestDto.getMobile();
		this.address = memberCreateRequestDto.getAddress();
	}

}
