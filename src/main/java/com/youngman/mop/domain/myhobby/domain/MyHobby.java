package com.youngman.mop.domain.myhobby.domain;

import com.youngman.mop.domain.hobby.domain.Hobby;
import com.youngman.mop.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Entity
@Table(name = "my_hobby_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyHobby {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "my_hobby_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hobby_id")
	private Hobby hobby;

}
