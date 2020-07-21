package com.youngman.mop.domain.schedule.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-12-23.
 */

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Writer {

	@Column(name = "member_id")
	private Long memberId;

	@Column(name = "member_name")
	private String memberName;

	public Writer(Long memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
}
