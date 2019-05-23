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

	private String name;
	private String introduce;
	private String region;
	private String hobby;
}
