package com.youngman.mop.domain.club.command.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by YoungMan on 2019-12-23.
 */

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubChair {

	@Column(name = "chairman_id")
	private Long chairManId;

	@Column(name = "vice_chairman_id")
	private Long viceChairManId;

	public ClubChair(Long chairManId, Long viceChairManId) {
		checkEqual();
		this.chairManId = chairManId;
		this.viceChairManId = viceChairManId;
	}

	public void setChairManId(Long chairManId) {
		this.chairManId = chairManId;
		checkEqual();
	}

	public void setViceChairManId(Long viceChairManId) {
		this.viceChairManId = viceChairManId;
		checkEqual();
	}

	private void checkEqual() {
		if (chairManId.equals(viceChairManId)) {
			throw new RuntimeException("회장, 부회장은 동일 인물이 될 수 없습니다.");
		}
	}
}