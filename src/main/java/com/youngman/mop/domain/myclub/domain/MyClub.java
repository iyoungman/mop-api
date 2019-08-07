package com.youngman.mop.domain.myclub.domain;

import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.model.BaseDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by YoungMan on 2019-05-12.
 */

@Entity
@Table(name = "my_club_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyClub extends BaseDate implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "my_club_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "club_id")
	private Club club;

	@Builder
	public MyClub(Member member, Club club) {
		this.member = member;
		this.club = club;
	}

	public static MyClub of(Member member, Club club) {
		return MyClub.builder()
				.member(member)
				.club(club)
				.build();
	}

}
