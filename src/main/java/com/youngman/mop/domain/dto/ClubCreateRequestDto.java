package com.youngman.mop.domain.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubCreateRequestDto {

	private Long clubId;
	private String name;
	private String introduce;
	private String region;
	private String hobby;


	@Builder
	public ClubCreateRequestDto(Long clubId, String name, String introduce, String region, String hobby) {
		this.clubId = clubId;
		this.name = name;
		this.introduce = introduce;
		this.region = region;
		this.hobby = hobby;
	}
}
