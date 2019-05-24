package com.youngman.mop.model.dto;

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

	private Long id;
	private String name;
	private String introduce;
	private String region;
	private String hobby;

	@Builder
	public ClubCreateRequestDto(Long id, String name, String introduce, String region, String hobby) {
		this.id = id;
		this.name = name;
		this.introduce = introduce;
		this.region = region;
		this.hobby = hobby;
	}
}
