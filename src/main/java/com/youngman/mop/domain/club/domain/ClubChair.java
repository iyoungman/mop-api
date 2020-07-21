package com.youngman.mop.domain.club.domain;

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

	public ClubChair(Long chairManId) {
		this.chairManId = chairManId;
	}

	public ClubChair(Long chairManId, Long viceChairManId) {
		checkEqual();
		this.chairManId = chairManId;
		this.viceChairManId = viceChairManId;
	}

	public void setChairManId(Long chairManId) {
		checkEqual();
		this.chairManId = chairManId;
	}

	public void setViceChairManId(Long viceChairManId) {
		checkEqual();
		this.viceChairManId = viceChairManId;
	}

	private void checkEqual() {
		if (chairManId.equals(viceChairManId)) {
			throw new RuntimeException("회장, 부회장은 동일 인물이 될 수 없습니다.");
		}
	}
}
